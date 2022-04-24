import src.Atoms;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args)
    {
        ArrayList<Atoms> atoms = new ArrayList<Atoms>();
        
        boolean status = true;
        do
        {
            Atoms bufferAtoms = new Atoms();
            bufferAtoms.accept();
            if(bufferAtoms.getNumber() == 0)
            {
                status = false;
                continue;
            }
            atoms.add(bufferAtoms);
        }while(status);
        for(int i = 0; i < atoms.size(); i++)
        {
            atoms.get(i).display();
        }
    }
}
/*----------------------------------------------------------------
3
Li
lithium
6.941
20
Ca
Calcium
40.078
30
Zn
zinc
65.409
0

----------------------------------------------------------------*/
