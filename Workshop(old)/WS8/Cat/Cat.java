import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
public class Cat {
    public static void main(String[] args)
    {
        try
        {
            FileReader reader;
            Scanner in = new Scanner(System.in);
            if(args.length < 1)
            {
                
                System.out.println("Enter the file's name: ");
                reader = new FileReader(in.nextLine());
                in.close();
            }
            else
            {
                reader = new FileReader(args[0]);
            }
            
            System.out.println("----------------------------------------------------------------");
            int data;
            do
            {
                data = reader.read();
                if(data != -1) System.out.print((char)data);
            } while(data != -1);
            reader.close();
        }catch (IOException e)
        {
            System.out.println("File does not exist.");
        }
        
        
    }
}
