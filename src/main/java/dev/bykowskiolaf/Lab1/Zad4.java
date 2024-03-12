//4. Zapelnić trzy tablice wartościami losowymi. Wyznaczyć wartość najwiekszą z każdej
//tablicy. Nastepnie wyznaczyé wartość najwiekszą spośród maksimów tych trzech
//tablic.

package dev.bykowskiolaf.Lab1;

import java.security.SecureRandom;
import java.util.Arrays;


/**
 * This class demonstrates operations on three arrays, including filling them with random numbers,
 * finding the maximum value in each, and determining the greatest maximum value among them.
 */
public class Zad4 {

    /**
     * Fills the given array with random numbers between 0 (inclusive) and 100 (exclusive).
     * @param array the array to be filled with random numbers.
     */
    void fillRandom(int[] array) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 100);
        }
    }

    /**
     * Finds and returns the maximum value in the given array.
     * @param array the array to search for the maximum value.
     * @return the maximum value found in the array.
     */
    int findMax(int[] array) {
        if (Arrays.stream(array).max().isEmpty()) {
            throw new IllegalArgumentException("Array is empty");
        }
        return Arrays.stream(array).max().getAsInt();
    }

    /**
     * The main method where three arrays are filled with random values, and the maximum values of each are determined.
     * Finally, it finds the largest maximum value among the three maximum values.
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        Zad4 zad4 = new Zad4();
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];

        // Fill arrays with random numbers
        zad4.fillRandom(array1);
        zad4.fillRandom(array2);
        zad4.fillRandom(array3);

        // Print the filled arrays
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));

        // Find the maximum value in each array
        int max1 = zad4.findMax(array1);
        int max2 = zad4.findMax(array2);
        int max3 = zad4.findMax(array3);

        // Find the maximum among the maximum values of each array
        int[] maxArray = {max1, max2, max3};
        int maxMax = zad4.findMax(maxArray);

        // Print the maximum values and the maximum of maximums
        System.out.println("Max1: " + max1);
        System.out.println("Max2: " + max2);
        System.out.println("Max3: " + max3);
        System.out.println("MaxMax: " + maxMax);
    }
}
