import java.util.Scanner;
public class StartingTime {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Starting hour: ");
        int hour = in.nextInt();
        System.out.println("Sarting Minues:");
        int minues = in.nextInt();
        System.err.println(hour + " hours and " + minues + " would be " + ((hour*60)+minues) + " total minues");
    }
}
