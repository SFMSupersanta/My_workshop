import java.util.Scanner;
import java.util.Arrays;
public class IntArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
        }
        System.out.println("All elements in the array:" + Arrays.toString(a));
        System.out.println("As sorted list:");
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("Max value: " + a[a.length - 1]);
    }
    
}
