public class Main {
    public static void main(String[] args)
    {
        Inputter input = new Inputter();
        String barrier  = "--------------------------------------------------------";
        StringTrans string = new StringTrans("financing Promoting Technology was established with the mission to develop a 'new generation university' with a    modern educational philosophy which combines training    activities with the actual need for skills in   the country, leveraging Vietnam to a level at which it can compete    with developed countries in the world. financing     Promoting Technology trains industrial engineers, and this requires a close association with IT firms, combining   training with      reality to be able to implement the most advanced technologies.");
        System.out.println("Yourstring:\n" + string);
        int choice = -1;
        do {
            System.out.println(barrier);
            System.out.println("Main menu:\n0. Show your string\n1. Cap the first character and first character each sentences.");
            System.out.println("2. delete exess blank space.");
            System.out.println("3. capitalize the word \"VietNam\".");
            System.out.println("4. changing financing Promoting Technology into FPT University.");
            System.out.println("5. Count the occurrences of vowels, consonants.");
            System.out.println("6. Exit the program.");
            System.out.println(barrier);
            choice = input.inputInt("Your choice: ",0,6);
            System.out.println(barrier);
            switch (choice) {
                case 0: 
                    System.out.println(string);
                break;
                case 1:
                    System.out.println("The string after transformation:\n" + string.capFirst());
                break;
                case 2:
                    System.out.println("The string after transformation: \n" + string.rmBlank());
                break;
                case 3:
                    System.out.println("The string after transformation: \n" + string.upper());
                break;
                case 4:
                    System.out.println("The string after transformation: \n" + string.findFinancing());
                break;
                case 5:
                    string.displayConsonantOccurrences();
                break;
            }
        } while (choice != 6);
    }
}