import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<PhoneNumer> numbers = new ArrayList<PhoneNumer>();
        boolean status = true;
        do
        {
            System.out.print("Type of phone number ? (1 - local phone, 2 - Inter phone number, 0 - exit): ");
            int local = in.nextInt();
            in.nextLine();
            if (local == 0)
            {
                status = false;
                continue;
            }
            else if(local == 1)
            {
                PhoneNumer phone = new PhoneNumer();
                System.out.print("Enter area code: ");
                phone.setArea(in.nextInt());
                in.nextLine();
                System.out.print("Enter number: ");
                phone.setNumber(in.nextLine());
                numbers.add(phone);
            }else if(local == 2)
            {   
                IntPhoneNumber phone = new IntPhoneNumber();
                System.out.print("Enter country code: ");
                phone.setCountryCode(in.nextLine());
                System.out.print("Enter area code: ");
                phone.setArea(in.nextInt());
                in.nextLine();
                System.out.print("Enter number: ");
                phone.setNumber(in.nextLine());
                numbers.add(phone);
            }
        } while (status);
        for(int i = 0; i < numbers.size(); i++){
            numbers.get(i).display();
        }
    }
}
