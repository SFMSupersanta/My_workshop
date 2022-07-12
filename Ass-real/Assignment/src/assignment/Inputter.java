/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 * @category Input class
 * @since 06/03/2022 (mm/dd/yyyy)
 * @author Admin
 *         {@summary} Method: inputDouble inputInt inputNonBlankStr inputPatten
 */
public class Inputter {
    public static Scanner sc = new Scanner(System.in);

    /**
     * @param msg the message to display when inputting the number
     * @param min the minimum value
     * @param max the maximum value
     * @return input, a double value in the range [min, max]
     */
    static double inputDouble(String msg, int min, int max) {
        if (max < min) {
            int temp = max;
            max = min;
            min = temp;
        }
        double input;
        System.out.println(msg);
        do {
            while (!sc.hasNextDouble()) {
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

    /**
     * @param msg the message to display when inputting the number
     * @param min the minimum value
     * @param max the maximum value
     * @return input, an int value in the range [min, max]
     */
    public int inputInt(String msg, int min, int max) {
        if (max < min) {
            int temp = max;
            max = min;
            min = temp;
        }
        int input;
        System.out.println(msg);
        do {
            while (!sc.hasNextInt()) {
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

    /**
     * @param msg the message to display when inputting the number
     * @return a non empty string
     */
    public String inputNonBlankStr(String msg) {
        String input;
        System.out.println(msg);
        do {
            input = sc.nextLine();
            if (input.length() == 0)
                System.out.println("Cannot be blank");
        } while (input.length() == 0);
        return input;
    }

    /**
     * @param msg    the message to display when inputting the number
     * @param patten regex pattern so compare with the input
     * @return input, a string that has values within regex patten constrain
     */
    public String inputPatten(String msg, String partten) {
        System.out.println(msg);
        String input;
        boolean match;
        do {
            input = sc.nextLine().trim();
            match = input.matches(partten);
            if (!match)
                System.out.println("Partten is not matched!");
        } while (!match);
        return input;
    }
}
