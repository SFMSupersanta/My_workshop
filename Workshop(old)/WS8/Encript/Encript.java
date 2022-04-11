import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
public class Encript {
    public static void encrypt(FileReader file) 
    {
        try
        {
            FileWriter fw = new FileWriter("encripted.txt");
            int c = ' ';
            do
            {
                c = file.read();
                if(c != -1) fw.append((char)(c+3));
            } while (c != -1);
            fw.close();
        }catch (IOException e)
        {
            System.out.println("an exception occurred.");
            e.printStackTrace();

        } 
    }
}
