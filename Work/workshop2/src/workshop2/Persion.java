
package workshop2;

/**
 *
 * @author Admin
 */
public class Persion {
    String ID, Name, Address;
    int Age;

    public Persion() {
    }

    public Persion(String ID, String Name, String Address, int Age) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Age = Age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String toString() {
        return ID + "\t" + Name + "\t" + Age + "\t" + Address;
    }

    public void Display() {
        System.out.println(ID + "\t" + Name + "\t" + Age + "\t" + Address);
    }
}
