
import src.Car;
import src.Inputter;
import src.Menu;
import src.Brand;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;


public class CarList extends ArrayList<Car>{
    private BrandList brandlist = new BrandList();
    private Menu<Brand> brandip = new Menu<Brand>();
    Inputter ip = new Inputter();
    public CarList(BrandList brandlist) 
    {
        super();
        this.brandlist = brandlist;
    }
    public void removeID()
    {
        int index;
        do
        {
            index = searchID(ip.inputNonBlankStr("Input carID"));
            if(index == -1) System.out.println("Can't find car");
        } while(index == -1);

        this.remove(index);
    }
    public void updateCar()
    {
        int index;
        do
        {
            index = searchID(ip.inputNonBlankStr("Input carID"));
            if(index == -1) System.out.println("Can't find car");
        } while(index == -1);

        this.remove(index);
        String engineID;
        boolean found;
        do
        {    
            found = true;
            engineID = ip.inputPatten("Enter engineID (E00000)", "E[0-9]{5}");
            for(Car brand : this)
            {
                if(brand.getEngineID().equals(engineID))
                {
                    found = false;
                    System.out.println("EngineID already exist. Try again.");
                    continue;
                }
            }
        }while (!found);
        this.set(index, new Car(this.get(index).getCarID(), brandip.ref_getChoice(brandlist), ip.inputNonBlankStr("Enter color"), ip.inputPatten("Enter frame id (F0000)","F[0-9]{5}"), engineID));
    }
    public boolean loadFromFile(String filename)
    {
        File file = new File(filename);
        if(!file.exists()) return false;
        String buffer;
        try
        {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((buffer = br.readLine()) != null)
            {
                String[] slice = buffer.split(",");
                int index = brandlist.searchID(slice[1].strip());
                this.add(new Car(slice[0].strip(), brandlist.get(index), slice[2].strip(), slice[3].strip(), slice[4].strip()));
            }
            br.close();
            fr.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public void listCar()
    {
        Collections.sort(this, new Comparator<Car>(){
            public int compare(Car o1, Car o2)
            {
                int d = o1.getBrand().getBrandName().compareTo(o2.getBrand().getBrandName());
                if(d != 0) return d;
                return o1.getCarID().compareTo(o2.getCarID());
            }
        });
        for(Car e : this)
        {
            System.out.println(e);
        }
    }
    public boolean saveToFile(String filename)
    {
        File file = new File(filename);
        if(!file.exists()) return false;
        try
        {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Car e: this)
            {
                bw.write(e + "\n");
            }
            bw.close();
            fw.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public int searchID (String carID)
    {
        int i;
        for(i = 0; i < this.size(); i++)
        {    
            if(this.get(i).getCarID().strip().equals(carID))
            return i;
        }
        return -1;
    }
    public int searchFrame (String fID)
    {
        int i;
        for(i = 0; i < this.size(); i++)
        {    
            if(this.get(i).getFrameID().strip().equals(fID))
            return i;
        }
        return -1;
    }
    public int searchEngine (String eID)
    {
        int i;
        for(i = 0; i < this.size(); i++)
        {    
            if(this.get(i).getEngineID().strip().equals(eID))
            return i;
        }
        return -1;
    }
    public void addCar()
    {
        String ID;
        boolean found;
        do
        {
            found = true;
            ID  = ip.inputNonBlankStr("Enter car ID");
            for(Car brand : this)
            {
                if(brand.getCarID().equals(ID))
                {
                    found = false;
                    System.out.println("ID already exist. Try again.");
                    continue;
                }
            }
        } while(!found);
        String engineID;
        do
        {    
            found = true;
            engineID = ip.inputPatten("Enter engineID (E00000)", "E[0-9]{5}");
            for(Car brand : this)
            {
                if(brand.getEngineID().equals(engineID))
                {
                    found = false;
                    System.out.println("EngineID already exist. Try again.");
                    continue;
                }
            }
        }while (!found);
        this.add(new Car(ID, brandip.ref_getChoice(brandlist), ip.inputNonBlankStr("Enter color"), ip.inputPatten("Enter frame id (F0000)","F[0-9]{5}"), engineID));
    }
    public void printBasedBrandName ()
    {
        String search = ip.inputNonBlankStr("Enter part of brand name");
        int i = 0;
        for(Car car : this)
        { 
            if(car.getBrand().getBrandID().contains(search)) System.out.println(car.screenString());
            i += 1;
        }
        if(i == 0) System.out.println("No car found");
    }
}
