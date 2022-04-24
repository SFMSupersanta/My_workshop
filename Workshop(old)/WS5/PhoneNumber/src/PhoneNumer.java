package src;

public class PhoneNumer {
    private int area;
    private String number;
    public int getArea() {
        return area;
    }
    public void setArea(int area)
    {
        this.area = area;
    }
    public String getNumber()
    {
        return number;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }
    public PhoneNumer()
    {
        area = 0;
        number = null;
    }
    public PhoneNumer(int area, String number)
    {
        this.area = area;
        this.number = number;
    }
    public void display()
    {
        System.out.println(area + " - " + number);
    }
}
