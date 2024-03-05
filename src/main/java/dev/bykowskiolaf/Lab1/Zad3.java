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
import java.util.Collections;
import java.util.stream.Stream;

public class Zad3 {
    void fillRandom(int[] array) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (random.nextInt() % 100);
        }
    }

    void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    int[] findLargestThree(int[] array) {
        int[] largestThree = new int[3];
        int max = findMax(array);
        int secondMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > secondMax && array[i] < max) {
                secondMax = array[i];
            }
        }
        int thirdMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > thirdMax && array[i] < secondMax) {
                thirdMax = array[i];
            }
        }
        largestThree[0] = max;
        largestThree[1] = secondMax;
        largestThree[2] = thirdMax;
        return largestThree;
    }

    double findAverage(int[] array) {
        return Arrays.stream(array).average().getAsDouble();
    }

    void printReversed(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    void reverseArray(int[] array) {
        Collections.reverse(Arrays.asList(array));
    }

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
