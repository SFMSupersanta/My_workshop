package src;

public class IntPhoneNumber extends PhoneNumer{
    private String countryCode;
    public IntPhoneNumber()
    {
        super();
        countryCode = null;
    }
    public IntPhoneNumber(int area, String number, String countryCode)
    {
        super(area, number);
        this.countryCode  = countryCode;
    }
    public String getCountryCode()
    {
        return countryCode;
    }
    public void setCountryCode(String country)
    {
        this.countryCode = country;
    }
    @Override
    public void display()
    {
        System.out.print(countryCode + " - ");
        super.display();
    }
}
