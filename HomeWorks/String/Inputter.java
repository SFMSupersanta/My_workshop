

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
                System.out.print("Out of bound!");
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
        System.out.print(msg);
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
        System.out.print(msg);
        do
        {
            input = sc.nextLine();
            if(input.length() == 0)
            System.out.println("Cannot be blank");
        } while (input.length() == 0);
        return input;
    }
}
