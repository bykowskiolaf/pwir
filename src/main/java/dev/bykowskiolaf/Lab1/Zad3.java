//Napisać program, który:
//a) utworzy tablicę N liczb całkowitych i wypełni je wartościami losowymi (N — stała),
//b) wypisze na ekranie zawartość tablicy,
//c) wyznaczy największy oraz najmniejszy element tablicy,
//d) wyznaczy 3 największe elementy tablicy (nie sortować tablicy),
//e) wyznaczy średnią arytmetyczną elementów tablicy,
//f) wyświetli na ekranie zwartość tablicy w odwrotnej kolejności (od ostatniego elementu do pierwszego).
//g) odwróci kolejność elementów w tablicy (element ostatni staje się pierwszym, itd.)
//   Wszystkie wyznaczone elementy należy wyświetlić na ekranie monitora.

package dev.bykowskiolaf.Lab1;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * This class demonstrates various array operations including filling an array with random numbers,
 * finding maximum, minimum, three largest elements, calculating the average, and reversing the array.
 */
public class Zad3 {

    /**
     * Fills the given array with random numbers.
     *
     * @param array the array to fill with random numbers.
     */
    void fillRandom(int[] array) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Fixed to limit the random numbers between 0 and 99.
        }
    }

    /**
     * Prints the contents of the given array to the console.
     *
     * @param array the array to print.
     */
    void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Finds and returns the maximum value in the given array.
     *
     * @param array the array to search.
     * @return the maximum value in the array.
     */
    int findMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Finds and returns the minimum value in the given array.
     *
     * @param array the array to search.
     * @return the minimum value in the array.
     */
    int findMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Finds and returns an array of the three largest elements in the given array.
     *
     * @param array the array to search.
     * @return an array containing the three largest elements.
     */
    int[] findLargestThree(int[] array) {
        int[] largestThree = new int[3];
        Arrays.sort(array);
        int arrayLength = array.length;
        largestThree[0] = array[arrayLength - 1];
        largestThree[1] = array[arrayLength - 2];
        largestThree[2] = array[arrayLength - 3];
        return largestThree;
    }

    /**
     * Calculates and returns the average of the elements in the given array.
     *
     * @param array the array to calculate the average.
     * @return the average of the array elements.
     */
    double findAverage(int[] array) {
        return Arrays.stream(array).average().orElse(Double.NaN);
    }

    /**
     * Prints the contents of the given array in reverse order to the console.
     *
     * @param array the array to print in reverse order.
     */
    void printReversed(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Reverses the order of the elements in the given array.
     *
     * @param array the array to reverse.
     */
    void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    /**
     * Main method to demonstrate array operations.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        Zad3 zad3 = new Zad3();
        int[] array = new int[10];
        zad3.fillRandom(array);
        zad3.printArray(array);
        System.out.println("Max: " + zad3.findMax(array));
        System.out.println("Min: " + zad3.findMin(array));
        System.out.println("Largest three: " + Arrays.toString(zad3.findLargestThree(array)));
        System.out.println("Average: " + zad3.findAverage(array));
        zad3.printReversed(array);
        zad3.reverseArray(array);
        zad3.printArray(array);
    }
}
