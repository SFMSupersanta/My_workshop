
public class FPTUniversity extends University implements Role{

    private String address;
    public void createWorker() {
        System.out.println("providing human resources");
    }
    // constructors
    public FPTUniversity()
    {
        super();
        address = null;
    }
    public FPTUniversity(int size, String name, String address)
    {
        super(size, name);
        this.address = address;
    }
    // getter and setter
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    // Methods
    @Override
    public String toString()
    {
        return "FPTU has four campuses Hanoi, HCM, DaNang, CanTho, QuyNhon";
    }
    
}
