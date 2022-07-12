
public class Officer extends Person {
    private double Salary;

    public void setSalary(double salary) {
        this.Salary = salary;
    }

    Officer() {
        super();
        Salary = 0.0;
    }

    Officer(String name, double salary) {
        super(name);
        Salary = salary;
    }

    public void display() {
        super.display();
        System.out.println("salary: " + Salary);
    }

    public double getSalary() {
        return Salary;
    }
}
