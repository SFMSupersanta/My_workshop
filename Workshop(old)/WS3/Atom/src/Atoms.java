package src;
import java.util.Scanner;
public class Atoms {
    public int number;
    public String symbol;
    public String name;
    public double weight;
    public int getNumber() {
        return number;
    }
    public Atoms()
    {
        number = 0;
        symbol = null;
        name = null;
        weight = 0.0;
    }
    public Atoms(int number, String symbol, String name, double weight)
    {
        this.number = number;
        this.symbol = symbol;
        this.name = name;
        this.weight = weight;
    }
    public void accept()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter atomic number : ");
        number = in.nextInt();
        if(number == 0) return;
        in.nextLine();
        System.out.print("Enter symbol : ");
        symbol = in.nextLine();
        System.out.print("Enter full name : ");
        name = in.nextLine();
        System.out.print("Enter atomic weight : ");
        weight = in.nextDouble();
        in.nextLine();
    }
    public void display()
    {
        
        System.out.println(number + "\t" + symbol + "\t\t" + name + "\t\t" + weight);
    }
}
