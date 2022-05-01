package src;
import java.util.ArrayList;
import java.util.Scanner;
public class  Menu <E>{
    private static java.util.Scanner sc = new Scanner(System.in);
    public int int_getChoice(ArrayList<E> options)	
    {
        int size = 0;
        for(E thing : options)
        {
            System.out.println(size+1 + " " + thing);
            size += 1;
        }
        System.out.printf("Please choose an option 1..%d\n", options.size());
        int choice;
        do
        {
            while(!sc.hasNextInt())
            {
                System.out.println("Not a valid choice");
                sc.nextLine();
            }
            choice =  sc.nextInt();
            if(choice < 1 || choice > options.size()) System.out.println("Out of range");
        } while(choice < 1 || choice > options.size());
        return choice;
    }
    public E ref_getChoice(ArrayList<E> options)
    {
        int choice = int_getChoice(options);
        return options.get(choice - 1);
    }
}
