public class Main {
    public static void main(String[] args)
    {
        String barrier  = "--------------------------------------------------------";
        Inputter input = new Inputter();
        StringTrans string = new StringTrans(input.inputNonBlankStr("Type in a string: "));
        int choice = -1;
        do {
            System.out.println(barrier);
            System.out.println("Main menu:\n0. Show your string\n1. Cap the first character in every words.");
            System.out.println("2. Capitalize the string.");
            System.out.println("3. Lowercase the string.");
            System.out.println("4. Count the occurrences of every character.");
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
                    System.out.println("The string after transformation: " + string.capFirst());
                    choice = input.inputInt("Do you want to save the string? (1 yes) (2 no): ", 1,2);
                    if(choice == 1) string.setString(string.capFirst());
                break;
                case 2:
                    System.out.println("The string after transformation: " + string.upper());
                    choice = input.inputInt("Do you want to save the string? (1 yes) (2 no): ", 1,2);
                    if(choice == 1) string.setString(string.upper());
                break;
                case 3:
                    System.out.println("The stirng after transformation: " + string.lower());
                    choice = input.inputInt("Do you want to save the string? (1 yes) (2 no): ", 1,2);
                    if(choice == 1) string.setString(string.lower());
                break;
                case 4:
                    string.displayOccurrences();
                break;
                case 5:
                    string.displayConsonantOccurrences();
                break;
            }
        } while (choice != 6);
    }
}