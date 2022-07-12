import java.util.Scanner;
import java.util.ArrayList;
import src.Molecules;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Molecules> molarr = new ArrayList<Molecules>();

        String structure, name;
        double weight;
        boolean start = true;
        System.out.println("Molecular Information:");
        do {
            System.out.print("\nEnter structure : ");
            structure = in.nextLine();
            if (structure.equals("0")) {
                start = false;
                continue;
            }
            System.out.print("Enter name : ");
            name = in.nextLine();
            System.out.print("Enter weight : ");
            weight = in.nextDouble();
            in.nextLine();
            Molecules bufferMol = new Molecules(structure, name, weight);
            molarr.add(bufferMol);
        } while (start);
        System.out.println();
        for (int i = 0; i < molarr.size(); i++) {
            molarr.get(i).display();
        }
    }
}
/*
 * H20
 * Water
 * 17.015
 * CO2
 * Carbon
 * 44.010
 * NaCl
 * Sodium
 * 58.443
 * 0
 * 
 */
