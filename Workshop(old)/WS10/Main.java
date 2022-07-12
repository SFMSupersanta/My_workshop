import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GenericCar<Car> carList = new GenericCar<Car>();
        int choice;
        try {
            do {
                System.out.println("Input 1 to add new car to list");
                System.out.println("Input 2 to display all cars");
                System.out.println("Input 3 to see number of cars");
                System.out.println("Input 4 to check if the list is empty");
                System.out.println("Input 5 to remove car from list");
                System.out.println("Input 0 to exit program");
                System.out.println("Your choice: ");
                choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        Car car = new Car();
                        System.out.println("Input car's name:");
                        car.setName(in.nextLine());
                        System.out.println("Input car's production:");
                        car.setProduction(in.nextLine());
                        System.out.println("Input car's price:");
                        car.setPrice(in.nextDouble());
                        carList.add(car);
                        break;
                    case 2:
                        carList.display();
                        break;
                    case 3:
                        System.out.println(carList.size());
                        break;
                    case 4:
                        System.out.println("List empty status is: " + carList.checkEmpty());
                        break;
                    case 5:
                        System.out.println("The car's index to remove form the list is: ");
                        carList.remove(in.nextInt());
                        break;
                    default:
                        System.out.println("Input a valid choice");
                }
            } while (choice != 0);
        } catch (Exception e) {
            System.out.println("input error");
        }
    }
}
