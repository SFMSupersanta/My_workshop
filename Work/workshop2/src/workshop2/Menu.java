
package workshop2;

/**
 *
 * @author Admin
 */
public class Menu {
    int Num;
    String[] item = new String[10];

    public Menu() {
        Num = 0;
    }

    public void Add(String s) {
        // item = new String[Num];
        item[Num++] = s;
    }

    public void Display() {
        for (int i = 0; i < Num; i++) {
            System.out.println(item[i]);
        }
    }
}
