package dev.bykowskiolaf.Lab4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zad3 implements Runnable {

    public static int[] rand_array = new int[1_000_000_000];
    public int max = 0;
    public int min = 0;

    public void fillArray() {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < rand_array.length; i++) {
            rand_array[i] = random.nextInt();
        }
    }

    @Override
    public void run() {
        for (int j : rand_array) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }
    }

    public static void main(String[] args) {
        Zad3 zad3 = new Zad3();
        Thread thread = new Thread(zad3);
        zad3.fillArray();
        System.out.println("Array filled");
        long startTime = System.nanoTime();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Max: " + zad3.max);
        System.out.println("Min: " + zad3.min);
        System.out.println("Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
