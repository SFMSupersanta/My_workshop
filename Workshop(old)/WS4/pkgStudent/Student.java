

public class Student {
    private String id;
    private String name;
    private double mark;
    Student()
    {
        id = null;
        name = null;
        mark = 0.0;
    }
    Student(String id, String name, double mark)
    {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }
    public String toString() {
        return id + "," + name + "," + mark;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMark()
    {
        return mark;
    }
    public void setMark(double mark) {
        this.mark = mark;
    }
    public void dump()
    {
        System.out.println(id + "\t" + name + "\t" + mark);
    }
}
