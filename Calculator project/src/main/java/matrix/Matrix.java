package matrix;

import java.util.Arrays;

public class Matrix {
    private int[][] matrix1;
    private int[][] matrix2;
    private int rows1;
    private int rows2;
    private int column1;
    private int column2;


    /**
     * Constructor that set matrices and it's corresponding parameters
     *
     * @param matrix1 The first matrix
     * @param matrix2 The second matrix
     */
    public Matrix(int[][] matrix1, int[][] matrix2) {
        setMatrix1(matrix1);
        setMatrix2(matrix2);
        setColumn1(matrix1[0].length);
        setColumn2(matrix2[0].length);
        setRows1(matrix1.length);
        setRows2(matrix2.length);
    }

    /**
     * Static method for printing a matrix
     *
     * @param matrix Matrix to turn into string
     * @return a string which represents a matrix
     */
    public static String toText(int[][] matrix) {
        StringBuilder ret = new StringBuilder();
        for (int[] arr : matrix) {
            ret.append(Arrays.toString(arr));
            ret.append("\n");
        }
        return ret.toString();
    }

    /**
     * Module testing main method
     *
     * @param argv Command line arguments
     */
    public static void main(String[] argv) {
        int[][] arr = new int[2][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;

        int[][] arr2 = new int[2][3];
        arr2[0][0] = 1;
        arr2[0][1] = 2;
        arr2[0][2] = 3;
        arr2[1][0] = 4;
        arr2[1][1] = 5;
        arr2[1][2] = 6;

        int[][] arr3 = new int[3][2];
        arr3[0][0] = 1;
        arr3[0][1] = 2;
        arr3[1][0] = 3;
        arr3[1][1] = 4;
        arr3[2][0] = 5;
        arr3[2][1] = 6;

        Matrix op = new Matrix(arr, arr2);
        System.out.println("Matrices: ");
        System.out.println(Matrix.toText(op.getMatrix1()));
        System.out.println(Matrix.toText(op.getMatrix2()));

        System.out.println("\nSubtraction: \n");
        System.out.println(Matrix.toText(op.getDiffMatrix()));
        System.out.println("\nAdding: \n");
        System.out.println(Matrix.toText(op.getTotalMatrix()));

        System.out.println("\nMatrices:");
        op.setMatrix2(arr3);
        System.out.println(Matrix.toText(op.getMatrix1()));
        System.out.println(Matrix.toText(op.getMatrix2()));
        System.out.println();
        System.out.println("\nMultiplication: \n");
        System.out.println(Matrix.toText(op.getProductMatrix()));
    }

    /**
     * @return true if 2 matrices is addable, false otherwise
     */
    public boolean getAddable() {
        return getRows1() == getRows2() && getColumn1() == getColumn2();
    }

    /**
     * @return true if 2 matrices is able to multiple, false otherwise
     */
    public boolean getMutable() {
        return getColumn1() == getRows2();
    }

    /**
     * Matrices must be able to multiply, first matrix's columns must equal to second matrix's rows
     * @return A matrix that is the product of multiplying 2 matrices
     */
    public int[][] getProductMatrix() {
        int[][] result = new int[getRows1()][getColumn2()];
        if (getMutable()) {
            for (int i = 0; i < getRows1(); i++) {
                for (int j = 0; j < getColumn2(); j++)
                    for (int k = 0; k < getRows2(); k++)
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        } else throw new IllegalArgumentException("Unable to multiply 2 matrices");
        return result;
    }

    /**
     * Matrices must be addable, the columns and rows myst be equal
     * @return A matrix that is the result of adding 2 matrices
     */
    public int[][] getTotalMatrix() {
        int[][] result = new int[getRows1()][getColumn1()];
        if (getAddable()) {
            for (int i = 0; i < getRows1(); i++) {
                for (int j = 0; j < getColumn1(); j++)
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        } else throw new IllegalArgumentException("Unable to add 2 matrices");
        return result;
    }

    /**
     * Matrices must be subtractable, the columns and rows myst be equal
     * @return A matrix that is the result of subtracting 2 matrices
     */
    public int[][] getDiffMatrix() {
        int[][] result = new int[getRows1()][getColumn1()];
        if (getAddable()) {
            for (int i = 0; i < getRows1(); i++)
                for (int j = 0; j < getColumn1(); j++)
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
        } else throw new IllegalArgumentException("Unable to subtract matrices");
        return result;
    }

    /**
     * @return matrix 1
     */
    public int[][] getMatrix1() {
        return matrix1;
    }

    /**
     * @param matrix1 matrix to set
     */
    public void setMatrix1(int[][] matrix1) {
        this.matrix1 = matrix1;
        setColumn1(matrix1[0].length);
        setRows1(matrix1.length);
    }

    /**
     * @return matrix 2
     */
    public int[][] getMatrix2() {
        return matrix2;
    }

    /**
     * set matrix 2
     *
     * @param matrix2 A matrix to set
     */
    public void setMatrix2(int[][] matrix2) {
        this.matrix2 = matrix2;
        setColumn2(matrix2[0].length);
        setRows2(matrix2.length);
    }

    /**
     * @return rows of matrix 1
     */
    public int getRows1() {
        return rows1;
    }

    /**
     * rows to set
     *
     * @param rows1 rows to set
     */
    public void setRows1(int rows1) {
        this.rows1 = rows1;
    }

    /**
     * @return rows of matrix 2
     */
    public int getRows2() {
        return rows2;
    }

    /**
     * To set rows of matrix 2
     *
     * @param rows2 row to set
     */
    public void setRows2(int rows2) {
        this.rows2 = rows2;
    }

    /**
     * @return Column of matrix 1
     */
    public int getColumn1() {
        return column1;
    }

    /**
     * To set column for matrix1
     *
     * @param column1 column to set
     */
    public void setColumn1(int column1) {
        this.column1 = column1;
    }

    /**
     * @return Column of matrix 2
     */
    public int getColumn2() {
        return column2;
    }

    /**
     * To set column for matrix2
     *
     * @param column2 column to set
     */
    public void setColumn2(int column2) {
        this.column2 = column2;
    }
}
