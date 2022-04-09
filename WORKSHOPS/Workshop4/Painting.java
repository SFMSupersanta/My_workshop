import java.util.Scanner;

public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;
    // constructor
    Painting() 
    {
        super(0, null);
        height = 0;
        width = 0;
        isWatercolour = false;
        isFramed = false; 
    }
    Painting(int value, String creator, int height, int width, boolean isWatercolour, boolean isFramed)
    {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }
    //getter and setter
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public int getwidth()
    {
        return width;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public boolean getWaterColour()
    {
        return isWatercolour;
    }
    public void setIsWatercolour(boolean isWatercolour)
    {
        this.isWatercolour = isWatercolour;
    }
    public void setIsFramed(boolean isFramed)
    {
        this.isFramed = isFramed;
    }
    public boolean getFramed()
    {
        return isFramed;
    }
    // methods
    public void outputPainting()
    {
        System.out.println("------------------------------------");
        output();
        System.out.println("height: " + height + "\n" + "width" + width + "\n" + "isFramed: " + isFramed + "\n" + "isWaterColour: " + isWatercolour);
        System.out.println("------------------------------------");
    }

    public void inputPainting()
    {
        input();
        Scanner sc = new Scanner(System.in);
        int bufferInt;
        String bufferstring;
        boolean status = false;
        do
        {
            System.out.println("Input a height:");
            bufferInt = sc.nextInt();
        }while(bufferInt<=0);
        height = bufferInt;

        do
        {
            System.out.println("Input a width:");
            bufferInt = sc.nextInt();
        }while(bufferInt<=0);
        width = bufferInt;
        do
        {
            System.out.println("Is the paint water colour? (True, False)");
            bufferstring = sc.nextLine();
            if(bufferstring.toLowerCase().equals("true"))
            {
               setIsWatercolour(true);
               status = true; 
            } 
            else if (bufferstring.toLowerCase().equals("false")) 
            {
                setIsWatercolour(false);
                status = true; 
            }
            else status = false; 
        }while(status == false);

        do
        {
            
            System.out.println("Is the paint framed? (True, False)");
            bufferstring = sc.nextLine();
            if(bufferstring.toLowerCase().equals("true"))
            {
               setIsFramed(true);
               status = true; 
            } 
            else if (bufferstring.toLowerCase().equals("false")) 
            {
                setIsFramed(false);
                status = true; 
            }
            else status = false; 
        }while(status == false);
    }
}
