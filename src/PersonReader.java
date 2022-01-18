import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PersonReader {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = null;
        ArrayList<Person> people = new ArrayList<>();
        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            in = new Scanner(selectedFile);
        }

        while (in.hasNext()) {
            people.add(new Person(removeComma(in.next()), removeComma(in.next()), removeComma(in.next()), removeComma(in.next()), in.nextInt()));
        }

        System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "ID#", "First Name", "Last Name", "Title", "YOB");
        System.out.println("======================================================================");

        for (Person var : people) {
            System.out.printf("%-15s", var.getID());
            System.out.printf("%-15s", var.getFirstName());
            System.out.printf("%-15s", var.getLastName());
            System.out.printf("%-15s", var.getTitle());
            System.out.printf("%-15d\n", var.getYOB());
        }
    }
    private static String removeComma(String inString) {
        return inString.substring(0, inString.length() - 1);
    }
}
