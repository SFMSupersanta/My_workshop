import java.util.Scanner;
import src.Book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter title : ");
        book.setTitle(in.nextLine());
        System.out.print("Enter number of pages: ");
        book.setPage(in.nextInt());
        System.out.print("Enter cost: ");
        book.setCost(in.nextDouble());
        System.out.print("Enter fiction(true/false): ");
        book.setFiction(in.nextBoolean());
        book.dump();
        System.out.print("Enter new cost: ");
        book.setCost(in.nextDouble());
        book.dump();
    }
}
