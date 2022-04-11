import java.util.ArrayList;

class GenericCar<Thing> 
{
    Thing thing;
    private ArrayList<Thing> list = new ArrayList<Thing>();
    public void add(Thing thing)
    {
        list.add(thing);
    }
    public void addMany(Thing[] things)
    {
        for (Thing thing : things)
        {
            list.add(thing);
        }
    }
    public void remove(int index)
    {
        list.remove(index);
    }
    public void display()
    {
        for(Thing thing : list)
        {
            System.out.println(thing);
        }
    }
    public boolean checkEmpty()
    {
        return list.isEmpty();
    }
    public int size()
    {
        return list.size();
    }

}