//5. Napisać program, który wypełni dwie macierze wartościami losowymi a nastepnie
//wykonuje operacje mnożenia tych macierzy. Po wykonanych obliczeniach wyświetl
//macierze źródłowe i macierz docelowq.

package dev.bykowskiolaf.Lab1;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * This class demonstrates matrix operations. It includes methods to fill matrices with random values and to multiply two matrices.
 */
public class Zad5 {

    /**
     * Fills a given matrix with random values between 0 and 9.
     *
     * @param matrix The matrix to be filled with random values.
     */
    void fillRandom(int[][] matrix) {
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) { // Fixed: Use matrix[i].length for column size
                matrix[i][j] = random.nextInt(10);
            }
        }
    }

    /**
     * Multiplies two matrices and returns the resultant matrix.
     *
     * @param matrix1 The first matrix.
     * @param matrix2 The second matrix.
     * @return The resulting matrix after multiplication.
     * @throws IllegalArgumentException if the number of columns in the first matrix does not equal the number of rows in the second matrix.
     */
    int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrix1 columns must be equal to matrix2 rows");
        }

        final int size = matrix1.length;

        int[][] tmp = new int[size][matrix2[0].length]; // Adjusted to handle non-square matrices

        for (int i = 0; i < tmp.length; i++) { // Iterate through rows of the result matrix
            for (int j = 0; j < tmp[i].length; j++) { // Iterate through columns of the result matrix
                tmp[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) { // Iterate through columns of matrix1/rows of matrix2
                    tmp[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return tmp;
    }

    /**
     * The main method to demonstrate matrix multiplication.
     * It fills two matrices with random values, prints them, multiplies them, and then prints the resultant matrix.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {
        Zad5 zad5 = new Zad5();
        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = new int[2][2];

        zad5.fillRandom(matrix1);
        zad5.fillRandom(matrix2);

        System.out.println("Matrix1:");
        printMatrix(matrix1);

        System.out.println("Matrix2:");
        printMatrix(matrix2);

        System.out.println("Result:");
        int[][] rsl = zad5.multiplyMatrices(matrix1, matrix2);
        printMatrix(rsl);
    }

    /**
     * Prints the given matrix to the standard output.
     *
     * @param mat The matrix to print.
     */
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

}
