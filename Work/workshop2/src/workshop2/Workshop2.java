
package workshop2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Workshop2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        StudentList sv = new StudentList();
        // sv.num=10;
        Menu menu = new Menu();
        menu.Add("==========Menu==========");
        menu.Add("1. Them sinh vien");
        menu.Add("2. Xoa sinh vien");
        menu.Add("3. Hien thi danh sach sinh vien");
        menu.Add("0. Thoat khoi chuong trinh");
        menu.Add("Lua chon chuc nang: ");
        int chon = 0;
        Scanner scan = new Scanner(System.in);
        do {
            menu.Display();
            chon = scan.nextInt();
            switch (chon) {
                case 0:
                    break; // thoat
                case 1:
                    sv.add(); // them sv
                    break;
                case 2:
                    sv.delete(); // xoa sv
                    break;
                case 3:
                    for (int i = 0; i < sv.getNum(); i++)
                        sv.sv[i].Display(); // hien thi list
                    break;
                default:
                    System.out.println("Wrong number"); // khong lam gi
                    break;
            }

        } while (chon != 0);
    }

}
