
import java.util.ArrayList;

import mainPackage.Menu;
import mainPackage.BookList;

public class Main {
    public static void main(String args[])
    {
        ArrayList<String> Options = new ArrayList<String>();
        
        Options.add("Input & add book(s) to the end.");
        Options.add("Display all books.");
        Options.add("Search a book for given code.");
        Options.add("Update the book's price for given code");
        Options.add("Find the (first) max price value.");
        Options.add("Sort the list ascendingly by code.");
        Options.add("Remove the book having given code.");
        Options.add("Load data from file.");
        Options.add("Save to file.");
        Options.add("To exit.");

        Menu<String> opsMenu = new Menu<String>();
        int choice;
        BookList list = new BookList();
        do
        {
            choice = opsMenu.int_getChoice(Options);
            switch(choice)
            {
                case 1:
                    list.addBook();
                break;
                case 2:
                    list.display();
                break;
                case 3:
                    list.searchCode();
                break; 
                case 4:
                    list.updatePrice();
                break;
                case 5:
                    System.out.println("The max price is: " + list.searchMax());
                break;
                case 6:
                    list.sort();
                break;
                case 7:
                    list.removeCode();
                break;
                case 8:
                    list.load("booklist.txt");
                break;
                case 9:
                    list.write("booklist.txt");
                break;
                default:
                    System.out.println("Exiting...");
            }
        } while (choice != Options.size());
    }
}