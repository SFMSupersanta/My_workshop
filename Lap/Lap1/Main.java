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
                    System.out.println();
                    int n  = input.inputInt("Type in the number: ",-1000000,1000000);
                    int arr[] = new int[n];
                    for(int i = 0; i < n; i+= 1)
                    {
                        arr[i] = input.inputInt("The " + (i+1) + " element: ",-1000000,1000000);
                    }
                    
                    do
                    {
                        choice = input.inputInt("Press 1 to find biggest, smallest elements\nPress 2 to sort the list assendingly\nPress 3 to sort the list decendingly\nPress 4 to find number of odds, evens\nPress 5 to return to main menu\nYour choice: ",1,5);
                        switch(choice)
                        {
                            case 1: 
                                Arrays.sort(arr);
                                System.out.println("The smallest element is: " + arr[0]);
                                System.out.println("The biggest element is : " + arr[n-1]);
                            break;
                            case 2:
                                Arrays.sort(arr);
                                System.out.printf("sorted array: %s\n", Arrays.toString(arr));
                            break;
                            case 3:
                                Arrays.sort(arr);
                                int rarr[] = new int[n];
                                for(int i = 0; i < n; i+= 1) rarr[i] = arr[n-1-i];
                                System.out.println("Reversed sorted array: " + Arrays.toString(rarr));
                            break;
                            case 4:
                                int odd=0, even=0;
                                for(int i: arr)
                                {
                                    if(i % 2 == 0) odd += 1;
                                    else even += 1;
                                }
                                System.out.println("Even numbers: ");
                                for(int i: arr) if(i % 2 == 0) System.out.print(i + " ");
                                System.out.println();
                                System.out.println("Odd numbers: ");
                                for(int i: arr) if(i % 2 == 1) System.out.print(i + " ");
                                System.out.println();
                                System.out.println("Number of odd: " + odd);
                                System.out.println("Number of even: " + even);
                            break;
                            default: System.out.println("Returning to the main menu");
                        }
                    } while (choice != 5);
                break;
                case 2:
                    Operations op = new Operations();
                    
                    do
                    {
                        choice = input.inputInt("Type 1 to plus 2 matrices\nType 2 to multiply 2 matrices\n3 to return to the main menu\nYour choice: ", 1,3);
                        switch(choice)
                        {
                            case 1:
                                op.plusArrays();
                            break;
                            case 2:
                                op.multiplyArrays();
                            break;
                            default: System.out.println("Return to the main menu."); 
                        }
                    } while (choice != 3);
                break;
                case 3:
                    System.out.println("Exiting the program.");
                break;
            }
        } while (choice != 3);
    }
}
