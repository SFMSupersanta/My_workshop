 public class Main {
        public static void main(String[] args) {
    int a, b, c;
            Scanner nhap = new Scanner(System.in);
            while (true) {
                //enter integer a here with input validation
                //enter integer b here with input validation
                //enter integer c here with input validation
    
                try {
                    //call constructor of RightTriangle class
    RightTriangle rt = new RightTriangle(a, b, c);
    System.out.println("This is a right triangle!");
                } catch (IllegalTriangleException e1) {
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
    
    
}
