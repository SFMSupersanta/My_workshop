import java.util.Arrays;
public class Main {
    public static void main(String[] args)
    {
        String border = "-----------------------------------------------------------";
        Inputter input = new Inputter();
        int choice = 0;
        do
        {
            System.out.println(border);
            choice = input.inputInt("Press 1 to operate 1d array, 2 to operate 2d array, 3 to exit the program\nYour choice: ", 1, 3);
            switch (choice) {

                case 1: 
                    ArrOperations arrop = new ArrOperations();
                    
                    System.out.println();
                    arrop.inputArr();
                    do
                    {
                        choice = input.inputInt("Press 1 to find biggest, smallest elements\nPress 2 to sort the list assendingly\nPress 3 to sort the list decendingly\nPress 4 to find number of odds, evens\nPress 5 to return to main menu\nYour choice: ",1,5);
                        switch(choice)
                        {
                            case 1: 
                                arrop.sorting();
                                System.out.println("The smallest element is: " + arrop.getMinimum());
                                System.out.println("The biggest element is : " + arrop.getMaximum());
                            break;
                            case 2:
                                arrop.sorting();
                                System.out.printf("sorted array: %s\n", arrop);
                            break;
                            case 3:
                                arrop.revsort();
                                System.out.println("Reversed sorted array: " + arrop);
                            break;
                            case 4:
                                arrop.displayOddEven();
                            break;
                            default: System.out.println("Returning to the main menu");
                        }
                    } while (choice != 5);
                break;
                case 2:
                    Operations op = new Operations();
                    op.inputArr();
                    do
                    {
                        choice = input.inputInt("Type 0 to subtract matrices\nType 1 to plus 2 matrices\nType 2 to multiply 2 matrices\n3 to return to the main menu\nYour choice: ", 0,3);
                        switch(choice)
                        {
                            case 0:
                                if(op.isAddable())op.minusArrays();
                                else System.out.println("Can't subtract matrices(rows and columns are not equal)");
                            break;
                            case 1:
                                if(op.isAddable())op.plusArrays();
                                else System.out.println("Can't add matrices(rows and columns are not equal)");
                            break;
                            case 2:
                                if(op.isMulable())op.multiplyArrays();
                                else System.out.println("Can't multiply matrices(Matrix 1's columns and Matrix 2' rows are not equal)");
                            break;
                            default: System.out.println("Return to the main menu."); 
                        }
                    } while (choice != 3);
                    if(choice == 3 ) choice = 0;
                break;
                case 3:
                    System.out.println("Exiting the program.");
                break;
            }
        } while (choice != 3);
    }
}
