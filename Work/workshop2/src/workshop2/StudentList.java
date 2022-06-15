
package workshop2;

import java.util.Scanner;

public class StudentList {
    int num;
    Student sv [] = new Student[num];

    public StudentList() { // constructor, so luong sv la 10
        if (num<0) num=0;
        sv=new Student[10];
    }

    public Student[] getSv() {
        return sv;
    }

    public void setSv(Student[] sv) {
        this.sv = sv;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public StudentList(int num) {
        this.num = num;
    }
    public void add(){
    String ID="",Name="",Address="";
    int Age=40;
    String RollNum="",Class="";
    double Score=0;
    Scanner scan = new Scanner( System.in); // tao sanner
    boolean ok = true;
    do{
        ok = false; // dat dieu kien la false
        System.out.print("Enter RollNumber: ");RollNum=scan.nextLine();
        for (int i =0;i<num ;i++)   {
            if (sv[i].RollNum.equals(RollNum)){
                ok=true; // neu ton tai so
                System.out.println(RollNum+": allready exist."); 
            }
        }             
    } while (ok); // neu dieu kien la true thi tiep tuc
    System.out.print("Enter Name: ");Name=scan.nextLine(); // scan ten
    System.out.print("Enter Class: ");Class=scan.nextLine(); // scan lop
    System.out.print("Enter Score: ");Score=scan.nextDouble(); // scan diem
    sv[num++] =new Student(RollNum, Class, Score, ID, Name, Address, Age); // tao sv moi, cho vao mang sv
    }
    public void delete(){
        String RollNum="";
        int index = 0;
        Scanner scan = new Scanner( System.in);
        boolean ok = true;
        do{
            ok = false;
            System.out.print("Enter RollNumber: ");RollNum=scan.nextLine(); // nhap so sv
            for (int i =0;i<num ;i++)   {
                if (sv[i].RollNum.equals(RollNum)){ // neu da co so
                    ok=true; // dat ok bang true
                    index = i;  // lay index cua sv tim ra
                }
            }
            if(!ok) System.out.println(RollNum + ": does not exist");  // neu khong ton tai tiep tuc nhap
        } while (!ok);

        for(int i = index; i < num - 1; i++) // xoa sinh vien tai vi tri index
        {
                sv[i] = sv[i+1];
        }
        num --; // giam so num di 1

        
    }
}