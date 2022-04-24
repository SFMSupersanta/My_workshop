import java.util.Scanner;
import src.IllegalRightTriangleException;
import src.IllegalTriangleException;
import src.RightTriangle;
public class Main 
{
    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int a, b, c;
        while (true) {
            do
            {
                System.out.println("Nhap so a: ");
                while(!nhap.hasNextInt())
                {
                    System.out.println("Not a number");
                    nhap.nextLine();
                }
                a = nhap.nextInt();
                if (a < 0) System.out.println("Type in a positive number");
            } while (a < 0);
            do
            {
                System.out.println("Nhap so b: ");
                while(!nhap.hasNextInt())
                {
                    System.out.println("Not a number");
                    nhap.nextLine();
                }
                b = nhap.nextInt();
                if (b < 0) System.out.println("Type in a positive number");
            } while (a < 0);
            do
            {
                System.out.println("Nhap so c: ");
                while(!nhap.hasNextInt())
                {
                    System.out.println("Not a number");
                    nhap.nextLine();
                }
                c = nhap.nextInt();
                if (a < 0) System.out.println("Type in a positive number");
            } while (c < 0);

            try {
                //call constructor of RightTriangle class
                RightTriangle rt = new RightTriangle(a, b, c);
                System.out.println("This is a right triangle!");
                            } 
                catch (IllegalTriangleException e1) {
                System.out.println("This is not a triangle!");
                            } catch (IllegalRightTriangleException e2) {
                System.out.println("This is not a right triangle");
                            }
                            //continue?
                System.out.print("Continue?(Y/N):");
                //Enter a character
                char chon = nhap.next().charAt(0);
                if(chon != 'Y')
                break;
            }
    }
}
