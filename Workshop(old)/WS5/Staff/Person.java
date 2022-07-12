
public abstract class Person {
    private String name;

    Person() {
        name = null;
    }

    Person(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Person: " + name);
    }

    public abstract double getSalary();
}
