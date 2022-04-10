

public class Worker extends Person{
    private double hrs;
    final double RATE = 5.5;
    public double getHrs()
    {
        return hrs;
    }
    public void setHrs(double hrs)
    {
        this.hrs = hrs;
    }
    Worker()
    {
        super();
        hrs = 0.0;
    }
    Worker(String name, double hours)
    {
        super(name);
        hrs = hours;
    }
    public void display()
    {
        super.display();
        System.out.println("Woking hours: " + hrs);
        System.out.println("Salary: " + getSalary());
    }
    public double getSalary()
    {
        return hrs * RATE;
    }
}
