
package q2;

import java.util.Scanner;

/**
 *
 * @author trong hieu
 */
public class Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String id, name;
        Scanner sc = new Scanner(System.in);
        Utility u = new Utility();
        id = u.GetString(sc, "Enter student id (HE123456):", "[Hh][Ee][\\d]{6}");
        name = u.GetString(sc, "Enter name (NOT EMPTY):");
        System.out.println("OUTPUT");
        System.out.println(id);
        System.out.println(name);
    }

}
