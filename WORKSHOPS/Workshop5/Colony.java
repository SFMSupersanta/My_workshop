public class Colony extends Organization{

    private String place;
    public String getPlace() {
        return place;
    }
    public Colony()
    {
        super(0);
        place = null;
    }
    public Colony(int size, String place)
    {
        super(size);
        this.place = place;
    }
    @Override
    public void communicateByTool() {
        System.out.println("the colony communicate by sound");
    }
    public void reproduce()
    {
        System.out.println("Colony can reproduce itself through a process");
    }
    @Override
    public String toString()
    {
        return super.toString() + ", the colony's place is" + place;
    }
    public void grow()
    {
        System.out.println("an annual cycle of growth that begins in spring");
    }
}
