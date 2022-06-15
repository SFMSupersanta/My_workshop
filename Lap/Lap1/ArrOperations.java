import java.util.Arrays;
public class ArrOperations {
    private Inputter input = new Inputter();
    private int n;
    private int arr[];

    /**
     * @return Inputter return the input
     */
    public Inputter getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(Inputter input) {
        this.input = input;
    }

    /**
     * @return int return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * @return int return the arr[]
     */
    public int[] getArr() {
        return arr;
    }

    /**
     * @param arr[] the arr[] to set
     */
    public void setArr(int arr[]) {
        this.arr = arr;
    }

    public void inputArr()
    {
        n  = input.inputInt("Type in the number: ",-1000000,1000000);
        arr = new int[n];
        for(int i = 0; i < n; i+= 1)
        {
            arr[i] = input.inputInt("The " + (i+1) + " element: ",-1000000,1000000);
        }
    }

    public void sorting()
    {
        Arrays.sort(arr);
    }

    public void revsort()
    {
        sorting();
        for(int i = 0; i < n/2; i++)
        {
            int e = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = e;
        }
    }
    
    public int getMinimum()
    {
        sorting();
        return arr[0];
    }

    public int getMaximum()
    {
        sorting();
        return arr[arr.length - 1];
    }

    public String toString()
    { return Arrays.toString(arr);}

    public void displayOddEven()
    {
        int odd=0, even=0;
        for(int i: arr)
        {
            if(i % 2 == 0) odd += 1;
            else even += 1;
        }
        System.out.println("Even numbers: ");
        for(int i: arr) if(i % 2 == 0) System.out.print(i + " ");
        System.out.println();
        System.out.println("Odd numbers: ");
        for(int i: arr) if(i % 2 == 1) System.out.print(i + " ");
        System.out.println();
        System.out.println("Number of odd: " + odd);
        System.out.println("Number of even: " + even);
    }

}
