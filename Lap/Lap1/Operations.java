import java.util.Arrays;
import java.util.Properties;
public class Operations {
    private Inputter input = new Inputter();
    private int rows;
    private int cols; 
    private int rows2;
    private int cols2;
    private int arr1[][];
    private int arr2[][];

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
     * @return int return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return int return the cols
     */
    public int getCols() {
        return cols;
    }

    /**
     * @param cols the cols to set
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * @return int return the rows2
     */
    public int getRows2() {
        return rows2;
    }

    /**
     * @param rows2 the rows2 to set
     */
    public void setRows2(int rows2) {
        this.rows2 = rows2;
    }

    /**
     * @return int return the cols2
     */
    public int getCols2() {
        return cols2;
    }

    /**
     * @param cols2 the cols2 to set
     */
    public void setCols2(int cols2) {
        this.cols2 = cols2;
    }

    /**
     * @return int return the arr1[][]
     */
    public int[][] getArr1() {
        return arr1;
    }

    /**
     * @param arr1[][] the arr1[][] to set
     */
    public void setArr1(int arr1[][]) {
        this.arr1 = arr1;
    }

    /**
     * @return int return the arr2[][]
     */
    public int[][] getArr2() {
        return arr2;
    }

    /**
     * @param arr2[][] the arr2[][] to set
     */
    public void setArr2(int arr2[][]) {
        this.arr2 = arr2;
    }

    /**
     * @category default constructor
     */
    public Operations() {

    }

    
    /**
     * @category axulary method but used for public purposes
     * @return void
     * {@summary} Input all properties excepts Inputter instance
     */
    public void inputArr()
    {
        Inputter input = new Inputter();
        System.out.println("For the first matrix:");
        rows = input.inputInt("How many rows?(in range 1-100): ", 1,100);
        cols = input.inputInt("How many columns?(in range 1-100): ",1,100);
        arr1 = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr1[i][j] = input.inputInt("First matrix, row: " + (i+1) + " cols: " + (j+1) + "'s value: ", -10000000,10000000);
            }
        }
        System.out.println("For the second matrix:");
        rows2 = input.inputInt("How many rows for the second matrix (in range 1-100): ",1,100);
        cols2 = input.inputInt("How many columns?(in range 1-100): ",1,100);
        arr2 = new int[rows2][cols2];
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                arr2[i][j] = input.inputInt("Second matrix, row: " + (i+1) + " cols: " + (j+1) + "'s value: ", -10000000,10000000);
            }
        }
    }
    
    /**
     * @category functioning method
     * {@value} rows must be equal to rows1, cols must be equal to cols1
     * {@summary} return an array that is the sum of two property array
     * @return int[][] result
     */
    public int[][] plusArrays() {
        int result[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        showArray(arr1, rows, "The first array:");
        showArray(arr2, rows, "The second array:");
        showArray(result, rows);
        return result;
    }

    /**
     * @category functioning method
     * {@value} rows must be equal to rows1, cols must be equal to cols1
     * {@summary} return an array that is the remain of two property array
     * @return int[][] result
     */
    public int[][] minusArrays() {
        int result[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        showArray(arr1, rows, "The first array:");
        showArray(arr2, rows, "The second array:");
        showArray(result, rows);
        return result;
    }

    /**
     * @category functioning method
     * {@summary} return an array that is the multiplication of two property array
     * {@value} cols must be equal to rows2
     * @return int[][] result
     */
    public void multiplyArrays()
    {
        
        showArray(arr1, rows, "The first array:");
        showArray(arr2, rows2, "The second array:");
        int result[][] = new int[rows][cols2];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols2; j++)
            {
                for(int k = 0; k < rows2; k++)
                {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                    //System.out.println(arr1[i][k] + "*" + arr2[k][j]);
                }
            }
        }
        showArray(result, rows);
    }

    /**
     * @param arr int[][]
     * @param rows int
     * @param msg String
     * @return void
     * {@summary} printing an 2d array as matrix with message
     */
    private void showArray(int arr[][], int rows, String msg)
    {
        System.out.println(msg);
        for(int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    /**
     * @param arr int
     * @param rows int [][]
     * @return void
     * {@summary} printing an 2d matrix as matrix
     */
    private void showArray(int arr[][], int rows)
    {
        System.out.println("The result array :");
        for(int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public boolean isAddable()
    {
        if (cols2 != cols || rows2 != rows) return false;
        return true;
    }

    public boolean isMulable()
    {
        if (cols != rows2) return false;
        return true;
    }

}