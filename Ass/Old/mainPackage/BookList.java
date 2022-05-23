package mainPackage;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class BookList extends ArrayList<Book>{
    static Inputter input;
    static Scanner sc;
    public BookList(){
        super();
    }
    public void addBook(){
        String ID;
        input = new Inputter();
        ID = input.inputNonBlankStr("Please enter the book's Code: ");
        boolean exitLoop = true;
        do
        {
            for(Book book: this)
            {
                if(book.getCode().equals(ID))
                {
                    exitLoop = false;
                }
                
            }
            if(!exitLoop){
                System.out.println("Code already exist. Try again.");
                ID = input.inputNonBlankStr("Please enter the book's Code: ");
            }
        } while(!exitLoop);
        
        this.add(new Book(ID, input.inputNonBlankStr("Please enter the book's title: "), input.inputInt("Number of book: ", 0,1000000), input.inputDouble("Enter price: ", 0, 1000000)));
    }
    public void display()
    {
        System.out.println("All book in stock:\n_______________________________________________");
        for(Book book: this)
        {
            System.out.println(book);
        }
        System.out.println("_______________________________________________");
    }
    public void searchCode()
    {
        String code;
        input = new Inputter();
        code = input.inputNonBlankStr("Please enter the book's Code: ");
        boolean exitLoop = false;
        int index = - 1;
        do
        {
            for(int i = 0; i < this.size(); i+=1)
            {
                if(this.get(i).getCode().equals(code))
                {
                    exitLoop = true;
                    index = i;
                }
            }
            if(!exitLoop){
                System.out.println("Code not exist, please try again.");
                code = input.inputNonBlankStr("Please enter the book's Code: ");
            }
        } while(!exitLoop);
        System.out.println("Found: \n" + this.get(index));
    }
    public void updatePrice()
    {
        String code;
        input = new Inputter();
        code = input.inputNonBlankStr("Please enter the book's Code: ");
        boolean exitLoop = false;
        int index = - 1;
        do
        {
            for(int i = 0; i < this.size(); i+=1)
            {
                if(this.get(i).getCode().equals(code))
                {
                    exitLoop = true;
                    index = i;
                }
                
            }
            if(!exitLoop){
                System.out.println("Code not exist, please try again.");
                code = input.inputNonBlankStr("Please enter the book's Code: ");
            }
        } while(!exitLoop);
        System.out.println("Found: \n" + this.get(index));
        this.get(index).setPrice(input.inputDouble("Enter new price: ", 0, 100000));
    }
    public double searchMax()
    {
        double max = 0;
        for(Book book : this)
        {
            if(book.getPrice() > max)
            {
                max = book.getPrice();
            }
        }
        return max;
    }
    public void sort()
    {
        Collections.sort(this, new Comparator<Book>()
        {
            public int compare(Book o1, Book o2)
            {
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        display();
    }
    public void removeCode()
    {
        String code;
        input = new Inputter();
        code = input.inputNonBlankStr("Please enter the book's Code: ");
        boolean exitLoop = false;
        int index = -1;
        do
        {
            for(int i = 0; i < this.size(); i+=1)
            {
                if(this.get(i).getCode().equals(code))
                {
                    exitLoop = true;
                    index = i;
                }
                
            }
            if(!exitLoop){
                System.out.println("Code not exist, please try again.");
                code = input.inputNonBlankStr("Please enter the book's Code: ");
            }
        } while(!exitLoop);
        this.remove(index);
    }
    public void load(String filename)
    {
        try {
            FileReader read = new FileReader(filename);
            BufferedReader reader = new BufferedReader(read);
            this.clear();
            String buffer;
            while((buffer = reader.readLine()) != null)
            {
                String[] decode = buffer.split(";");
                this.add(new Book(decode[0].trim(), decode[1].trim(), Integer.parseInt(decode[2].trim()), Double.parseDouble(decode[3].trim())));
            }
            reader.close();
            read.close();
        } catch (IOException e) {
            System.out.println("An error occurred while loading the file");
            e.printStackTrace();
        }
    }
    public void write(String filename)
    {
        try {
            FileWriter write = new FileWriter(filename);
            BufferedWriter writer = new BufferedWriter(write);
            for(Book book : this)
            {
                writer.write(book.toFile());
            }
            writer.close();
            write.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
}
