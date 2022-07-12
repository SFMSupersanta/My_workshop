
package workshop2;

/**
 *
 * @author Admin
 */
public class Student extends Persion {
    String RollNum, Class;
    double Score;

    public Student() {
    }

    public Student(String RollNum, String Class, double Score) {
        this.RollNum = RollNum;
        this.Class = Class;
        this.Score = Score;
    }

    public Student(String RollNum, String Class, double Score, String ID, String Name, String Address, int Age) {
        super(ID, Name, Address, Age);
        this.RollNum = RollNum;
        this.Class = Class;
        this.Score = Score;
    }

    @Override
    public void Display() {
        System.out.println(RollNum + "\t" + Name + "\t" + Class + "\t" + Score);
    }

    @Override
    public String toString() {
        return RollNum + "\t" + Name + "\t" + Class + "\t" + Score;
    }

}
