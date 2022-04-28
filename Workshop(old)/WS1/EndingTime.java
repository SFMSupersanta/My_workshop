import java.util.Scanner;
public class EndingTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Starting hour: ");
        int hour = in.nextInt();
        System.out.println("Sarting Minues:");
        int minues = in.nextInt();
        System.out.println("Lasting time (minues):");
        int last = in.nextInt();
        in.close();
        int status = 0, overtime;
        if((last % 60) + minues >= 60) 
        {
            status = 1;
            overtime = ((minues + last) % 60);
        } else overtime = (minues + last)%60;
        System.out.println("if an event starts at " + hour + " " + minues + " and lasts " + last + " minutes, it will end at " + (hour + (last / 60) + status) % 24 + " " + overtime);
    }
}
