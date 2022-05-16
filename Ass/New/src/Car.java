package src;
public class Car{
    private String carID;
    private String color;
    private String frameID;
    private String engineID;
    private Brand brand;
    public Car(){}
    public Car(String carID, Brand brand, String color, String frameID, String engineID)
    {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }
    public String screenString()
    {
        return brand.getBrandID() + "\n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }
    public String getCarID() { return carID; }
    public String getColor() { return color; }
    public String getFrameID() { return frameID; }
    public String getEngineID() { return engineID; }
    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }
    public void setColor(String color) { this.color = color; }
    public void setFrameID(String frameID) { this.frameID = frameID;}
    public void setCarID(String carID) {this.carID = carID;}
    public void setEngineID(String engineID) {this.engineID = engineID;}
    public int compareTo(Car car) 
    {
        int d = this.brand.getBrandName().compareTo(car.brand.getBrandName());
        if (d != 0) return d;
        else return this.carID.compareTo(car.getCarID());
    }
    public String  toString()
    { return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;}
}