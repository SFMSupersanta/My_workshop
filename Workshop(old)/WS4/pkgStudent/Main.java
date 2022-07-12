import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter id: ");
        Student student = new Student();
        student.setId(in.nextLine());
        System.out.print("Enter name: ");
        student.setName(in.nextLine());
        System.out.print("Enter mark: ");
        student.setMark(in.nextDouble());
        System.out.println();
        System.out.println(student.toString());

    }
}
