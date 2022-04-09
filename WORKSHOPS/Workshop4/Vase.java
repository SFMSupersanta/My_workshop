import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;
    // constructor
    Vase()
    {
        super(0, null);
        height = 0;
        material = null;
    }
    Vase(int value, String creator, int height, String material)
    {
        super(value, creator);
        this.height = height;
        this.material = material;
    }
    // getter and setter
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public String getMaterial()
    {
        return material;
    }
    public void setMaterial(String material)
    {
        this.material = material;
    }
    // methods
    public void outputVase()
    {
        System.out.println("------------------------------------");
        output();
        System.out.println("height: " + height + "\n" + "material: " + material);
        System.out.println("------------------------------------");
    }
    public void inputVase()
    {
        input();
        Scanner sc = new Scanner(System.in);
        int bufferInt;
        String bufferstring;
        do
        {
            System.out.println("Input a height:");
            bufferInt = sc.nextInt();
        }while(bufferInt<=0);
        height = bufferInt;
        do
        {
            System.out.println("Input a material: ");
            bufferstring = sc.nextLine();
        }while(bufferstring.equals(""));
        material = bufferstring;
    }

}
