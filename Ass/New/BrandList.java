import java.util.ArrayList;
import src.Inputter;
import src.Brand;
import src.Menu;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class BrandList extends ArrayList<Brand>{
    public BrandList ()
    {
        super();
    }
    public boolean loadFromFile(String filename)
    {
        String bufferstring;
        File file = new File(filename);
        if (!file.exists()) return false;
        String split[];
        try
        {
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while((bufferstring = br.readLine()) != null)
            {
                split = bufferstring.split("[:,]");
                Brand bufBrand = new Brand(split[0].trim(), split[1].trim(), split[2].trim(), Double.parseDouble(split[3]));
                this.add(bufBrand);
            }
            br.close();
            fr.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public boolean saveToFile(String filename)
    {
        File file = new File(filename);
        if (!file.exists()) return false;
        try
        {
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Brand brand : this)
            {
                bw.write(brand.toString() + "\n");
            }
            bw.close();
            fw.close();
        }  catch (IOException e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public int searchID (String bID)
    {
        for(int i  = 0; i < this.size(); i++)
        {
            if(this.get(i).getBrandID().equals(bID))
            {
                return i;
            }
        }
        return -1;
    }
    public Brand getUserChoice()
    {
        Menu<Brand> menu = new Menu<Brand>();
        return menu.ref_getChoice(this);
    }
    public void addBrand()
    {   
        Inputter ip = new Inputter();
        String ID;
        boolean found;
        do
        {
            found = true;
            ID  = ip.inputNonBlankStr("Enter brand ID");
            for(Brand brand : this)
            {
                if(brand.getBrandID().equals(ID))
                {
                    found = false;
                    System.out.println("Brand already exist. Try again.");
                    continue;
                }
            }
        } while(!found);
        String name = ip.inputNonBlankStr("Enter brand name");
        String sound = ip.inputNonBlankStr("Enter sound brand name");
        double price = ip.inputDouble("Enter price", 0 , 10000000);
        this.add(new Brand(ID, name, sound, price));
    }
    public void listBrand()
    {
        for(Brand brand : this)
        System.out.println(brand);
    }
    public void updateBrand()
    {
        Inputter ip = new Inputter();
        int found;
        do
        {
            found = searchID(ip.inputNonBlankStr("Enter brand ID"));
            if(found == -1) System.out.println("Brand not found");
            else System.out.println("Found brand");
        } while(found == -1);
        String name = ip.inputNonBlankStr("Enter brand name");
        String sound = ip.inputNonBlankStr("Enter sound brand name");
        double price = ip.inputDouble("Enter price", 0 , 10000000);
        this.set(found, new Brand(this.get(found).getBrandID(), name, sound, price));
    }
}
