package src;
public class Molecules {
    public String structure;
    public String name;
    public double weight;
    public Molecules()
    {
        structure = null;
        name = null;
        weight = 0.0;
    }
    public Molecules(String structure, String name, double weight)
    {
        this.structure = structure;
        this.name = name;
        this.weight = weight;
    }
    public void display()
    {
        System.out.println(structure + "\t\t" + name + "\t\t" + weight);
    }
}
