
public class Car{
    private String colour;
    private int enginPower;
    private boolean convertable;
    private boolean parkingBreak;

    //constructor:
    Car(String a, int b, boolean c, boolean p)
    {
        colour = a;
        enginPower = b;
        convertable = c;
        parkingBreak = p;
    }
    //overloaded constructor
    Car()
    {
        colour = null;
        enginPower = 0;
        convertable = false;
        parkingBreak = false;
    }

    public String getColour()
    {
        return colour;
    }

    public int getEnginePower()
    {
        return enginPower;
    }

    public boolean getConvertable()
    {
        return convertable;
    }

    public boolean getParkingBreak()
    {
        return parkingBreak;
    }

    public void setColour(String cl)
    {
        colour = cl;
    }

    public void setEnginePower(int cl)
    {
        enginPower = cl;
    }

    public void setConvertable(boolean cl)
    {
        convertable = cl;
    }

    public void setParkingBreak(boolean cl)
    {
        parkingBreak = cl;
    }

    public void pressStartButton()
    {
        System.out.println("You have pressed the start button");
    }

    public void pressAcceleratorButton()
    {
        System.out.println("You have pressed the Accelerator button");
    }

    public void output()
    {
        System.out.println("colour: " + colour + "\nenginepower: " + enginPower + "\nconvertible: " + convertable + "\nparking break: " + parkingBreak);
    }

}