public class BeeColony extends Colony implements Role{

    private String type;
    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees");
        
    }
    // constructors
    BeeColony()
    {
        super();
        type = null;
    }
    BeeColony(int size, String place, String type)
    {
        super(size, place);
        this.type = type;
    }
    // getters and setters
    public String getType() 
    {
        return type;
    }
    public void setType(String type) 
    {
        this.type = type;
    }
    // methods
    public String toString() 
    {
        return "the colony's type is " + type + ", size is about " + size + " and the place is " + getPlace();
    }

    
}
