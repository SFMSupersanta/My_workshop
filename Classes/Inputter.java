
import java.util.Scanner;
public class Inputter {
    
    public static Scanner sc = new Scanner(System.in);
    public double inputDouble(String msg, int min, int max)
    {
        if(max < min) 
        {
            int temp = max;
            max = min;
            min = temp;
        }
        double input;
        System.out.print(msg);
        do
        {
            while(!sc.hasNextDouble())
            {
                System.out.println("Input a double!");
                sc.nextLine();
            }
            input = sc.nextDouble();
            if (input > max || input < min)
                System.out.println("Out of bound!");
        } while (input > max || input < min);
        sc.nextLine();
        return input;
    }
    public int inputInt(String msg, int min, int max)
    {
        if(max < min) 
        {
            int temp = max;
            max = min;
            min = temp;
        }
        int input;
        System.out.println(msg);
        do
        {
            while(!sc.hasNextInt())
            {
                System.out.println("Input an int!");
                sc.nextLine();
            }
            input = sc.nextInt();
            if (input > max || input < min)
                System.out.println("Out of bound!");
        } while (input > max || input < min);
        sc.nextLine();
        return input;
    }
    public String inputNonBlankStr(String msg)
    {
        String input;
        System.out.println(msg);
        do
        {
            input = sc.nextLine();
            if(input.length() == 0)
            System.out.println("Cannot be blank");
        } while (input.length() == 0);
        return input;
    }
    public String inputPatten(String msg, String partten)
    {
        System.out.println(msg);
        String input;
        boolean match;
        do
        {
            input = sc.nextLine().trim();
            match = input.matches(partten);
            if(!match) System.out.println("Partten is not matched!");
        } while (!match);
        return input;
    }
    public boolean inputYN(String msg)
    {
        String choice = "", collection = "ynYN";
        System.out.print(msg);
        do
        {
            do
            {
                choice = sc.nextLine();
                if(choice.length() != 1)
                    System.out.println("Not a valid choice");
            } while(choice.length() != 1);
            if(collection.indexOf((int)choice.charAt(0)) == -1) 
                System.out.println("Not a valid choice");
        } while (collection.indexOf((int)choice.charAt(0)) == -1);
        if("nN".indexOf((int)choice.charAt(0)) != -1) return false;
        return true;
    }
    public char inputChar(String msg,String collection)
    {
        String choice = "";
        System.out.print(msg);
        do
        {
            do
            {
                choice = sc.nextLine();
                if(choice.length() != 1)
                    System.out.println("Not a valid choice");
            } while(choice.length() != 1);
            if(collection.indexOf((int)choice.charAt(0)) == -1) 
                System.out.println("Not a valid choice");
        } while (collection.indexOf((int)choice.charAt(0)) == -1);
        return choice.charAt(0);
    }
}
