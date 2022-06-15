
package q2;

import java.util.Scanner;

/**
 *
 * @author Trong hieu
 */
public class Utility {
    public String GetString(Scanner sc, String msg)
    {
        String input;
        System.out.print(msg);
        do
        {
            input = sc.nextLine();
            if(input.length() == 0)
            System.out.print(msg);
        } while (input.length() == 0);
        return input;
    }
    public String GetString(Scanner sc, String msg, String partten)
    {
        System.out.print(msg);
        String input;
        boolean match;
        do
        {
            input = sc.nextLine().trim();
            match = input.matches(partten);
            if(!match) System.out.print(msg);
        } while (!match);
        return input;
    }
}
