import java.io.FileReader;
import java.io.IOException;
import src.Encript;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("toBeEncrypted.txt");
            Encript.encrypt(file);
        } catch (IOException e) {
            System.out.println("an exception occurred: " + e.getMessage());
        }
    }
}
