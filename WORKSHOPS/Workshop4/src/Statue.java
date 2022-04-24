package src;
import java.util.Scanner;

public class Statue extends Item
{
    private int  weight;
    private String colour;
    // constructors
    public Statue()
    {
        super(0, null);
        weight = 0;
        colour = null;
    }
    public Statue(int value, String creator, int weight, String colour)
    {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }
    // setters and getters
    public int getWeight()
    {
        return weight;
    }
    public void setWeight(int value)
    {
        this.weight = value;
    }
    public String getColor()
    {
        return colour;
    }
    public void setColor(String value)
    {
        this.colour = value;
    }
    // methods
    public void outputStatue()
    {
        System.out.println("------------------------------------");
        output();
        System.out.println("weight: " + weight + "\n" + "colour: " + colour);
        System.out.println("------------------------------------");
    }
    public void inputStatue()
    {
        input();
        Scanner sc = new Scanner(System.in);
        int bufferInt;
        String bufferstring;
        do
        {
            System.out.println("Input a weight:");
            bufferInt = sc.nextInt();
        }while(bufferInt<=0);
        weight = bufferInt;
        do
        {
            System.out.println("Input a colour:");
            bufferstring = sc.nextLine();
        }while(bufferstring.equals(""));
        colour = bufferstring;
    }

}