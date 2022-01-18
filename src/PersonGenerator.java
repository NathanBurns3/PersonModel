import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        while (SafeInput.getYNConfirm(in, "Add a file to the data chart?")) {
            System.out.print("ID Number: ");
            String ID = in.nextLine();
            System.out.print("First name: ");
            String firstName = in.nextLine();
            System.out.print("\nLast name: ");
            String lastName = in.nextLine();
            System.out.print("\nTitle: ");
            String title = in.nextLine();
            System.out.print("\nYear of birth: ");
            int YOB = in.nextInt();

            people.add(new Person(ID, firstName, lastName, title, YOB));
        }

        String textFileName = SafeInput.getNonZeroLenString(in, "\nEnter text file name");

        try {
            PrintWriter writer = new PrintWriter(textFileName);

            for(Person var : people) {
                writer.println(var.toCSV());
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}