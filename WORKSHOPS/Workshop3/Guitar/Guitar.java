
public class Guitar {

    private String serialNumber;
    private int price;
    private String builder;
    private String model;
    private String backwood;
    private String topWood;
 
    // constructor
    Guitar()
    {
        serialNumber = null;
        price = 0;
        builder = null;
        model = null;
        backwood = null;
        topWood = null;
    }
    Guitar(String inSerialNumber, int inPrice, String inBuilder, String inModel, String inBackwood, String inTopWood)
    {
        serialNumber = inSerialNumber;
        price = inPrice;
        builder = inBuilder;
        model = inModel;
        backwood = inBackwood;
        topWood = inTopWood;
    }
    //getter/setters
    String getSerialNumber()
    {
        return serialNumber;
    }
    void setSerialNumber(String inSerialNumber)
    {
        serialNumber = inSerialNumber;
    }
    String getBuilder()
    {
        return builder;
    }
    void setBuilder(String inBuilder)
    {
        builder = inBuilder;
    }
    String getModel()
    {
        return model;
    }
    void setModel(String inModel)
    {
        model = inModel;
    }
    String getBackwood()
    {
        return backwood;
    }
    void setBackwood(String inBackwood)
    {
        backwood = inBackwood;
    }
    String getTopwood()
    {
        return topWood;
    }
    void setTopwood(String inTopWood)
    {
        topWood = inTopWood;
    }
    int getPrice()
    {
        return price;
    }
    void setPrice(int inPrice)
    {
        price = inPrice;
    }
    // Echo
    void createSound()
    {
        System.out.println("serialNumber: " + serialNumber);
        System.out.println("price: " + price);
        System.out.println("builder: " + builder);
        System.out.println("model: " + model);
        System.out.println("backwood: " + backwood);
        System.out.println("topWood: " + topWood);
    }
}
