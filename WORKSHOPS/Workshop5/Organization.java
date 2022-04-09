

public abstract class Organization {
    public abstract void communicateByTool();
    protected int size;
    
    // constructor
    Organization()
    {
        size = 0;
    }
    // Methods
    public String toString()
    {
        return "the organization's size is " + size; 
    }
    Organization(int size)
    {
        this.size = size;
    }
    public int getSize()
    {
        return size;
    }
    public void setSize(int size)
    {
        this.size = size;
    }
}
