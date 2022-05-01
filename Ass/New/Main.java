import src.Menu;
import src.Inputter;
import java.util.ArrayList;

public class Main {
    public static void main(String args[])
    {
        Inputter inputter = new Inputter();
        ArrayList<String> Options = new ArrayList<String>();
        
        Options.add("List all brands");
        Options.add("Add a new brand");
        Options.add("Search a brand based on its ID");
        Options.add("Update a brand");
        Options.add("Save brands to the file, named brands.txt");
        Options.add("List all cars in ascending order of brand names");
        Options.add("List cars based on a part of an input brand name");
        Options.add("Add a car");
        Options.add("Remove a car based on its ID");
        Options.add("Update a car based on its ID");
        Options.add("Save cars to file, named cars.txt");
        Options.add("To exit");

        Menu<String> opsMenu = new Menu<String>();
        int choice;
        BrandList brandlist = new BrandList();
        brandlist.loadFromFile("brands.txt");
        CarList carlist = new CarList(brandlist);
        carlist.loadFromFile("cars.txt");
        do
        {
            choice = opsMenu.int_getChoice(Options);
            switch(choice)
            {
                case 1:
                    brandlist.listBrand();
                break;
                case 2:
                    brandlist.addBrand();
                break;
                case 3:
                    choice = brandlist.searchID(inputter.inputNonBlankStr("Input brand ID to search"));
                    if(choice != -1) 
                    {
                        System.out.println("Found: " + brandlist.get(choice)); 
                        choice = -1;
                    }else System.out.println("Can't find band");
                break;
                case 4:
                    brandlist.updateBrand();
                    System.out.println("Saved");
                break;
                case 5:
                    brandlist.saveToFile("brands.txt");
                    System.out.println("Saved");
                break;
                case 6:
                    carlist.listCar();
                break;
                case 7:
                    carlist.printBasedBrandName();
                break;
                case 8:
                    carlist.addCar();
                    System.out.println("Added Car");
                break;
                case 9:
                    carlist.removeID();
                break;
                case 10:
                    carlist.updateCar();
                break;
                case 11:
                    carlist.saveToFile("cars.txt");
                default:
                    System.out.println("Exiting...");
            }
        } while (choice != Options.size());
    }
}
