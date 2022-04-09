import java.util.Scanner;

public class Item {
    protected int value;
    protected String creator;
    // constructor:
    Item()
    {
        value = 0;
        creator = null;
    }
    Item(int value, String creator)
    {
        this.value = value;
        this.creator = creator;
    }
    public int getValue()
    {
        return value;
    }
    public String getCreator()
    {
        return creator;
    }
    public void setCreator(String creator)
    {
        this.creator = creator;
    }
    public void setValue(int value)
    {
        this.value = value;
    }
    // methods
    public void output()
    {
        System.out.println("value: " + value + "\n" + "creator: " + creator);
    }
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        String bufferstring;
        int bufferInt;
        do
        {
            System.out.print("Input value: ");
            bufferInt = sc.nextInt();
        }while(bufferInt <= 0);
        setValue(bufferInt);
        do
        {
            System.out.print("Input creator's name: ");
            bufferstring = sc.nextLine();
        }while(bufferstring.equals(""));
        creator = bufferstring;
    }
}
