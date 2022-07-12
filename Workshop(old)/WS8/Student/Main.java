import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import src.Student;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1.	Add a list of Students and save to File");
            System.out.println("2.	Loading list of Students from a File");
            System.out.println("3.	Exit");

            do {
                System.out.print("Your choice: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Enter a valid number (1,2,3)");
                    sc.nextLine();
                }
                choice = sc.nextInt();
                sc.nextLine();
                if (choice != 1 && choice != 2 && choice != 3)
                    System.out.println("Invalid choice, try again!");
            } while (choice != 1 && choice != 2 && choice != 3);

            if (choice == 1) {
                ArrayList<Student> list = new ArrayList<Student>();
                while (true) {

                    String name;
                    System.out.print("Type in student's name (0 to save to a file):");
                    name = sc.nextLine();
                    if (name.equals("0"))
                        break;
                    System.out.print("Enter student's age:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Please enter a number");
                        sc.nextLine();
                    }
                    int age = sc.nextInt();
                    System.out.print("Enter the student's mark:");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Please enter a mark");
                        sc.nextLine();
                    }
                    double mark = sc.nextDouble();
                    sc.nextLine();
                    list.add(new Student(name, age, mark));
                }
                try {
                    FileWriter writer = new FileWriter("data.txt");
                    for (Student e : list) {
                        writer.write(e.toString());
                        ;
                    }
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An exception occurred while saving to the file");
                    System.out.println(e);
                }

            } else if (choice == 2) {
                try {
                    System.out.print("Type in the file's name:");
                    String fileN = sc.nextLine();
                    FileReader reader = new FileReader(fileN);
                    BufferedReader fileIn = new BufferedReader(reader);
                    String buffer;
                    do {
                        buffer = fileIn.readLine();
                        System.out.println(buffer);
                    } while (buffer != null);
                } catch (IOException e) {
                    System.out.println("An exception occurred while opening the file");
                    System.out.println(e);
                }
            } else if (choice == 3) {
                System.out.println("Closing...");
            }
        } while (choice != 3);
        sc.close();
    }
}
