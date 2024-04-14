package dev.bykowskiolaf.Lab4.Zad4;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Test {
    public static final Integer ARRAY_SIZE = 500_000_000;
    public static Integer DIVIDE_INTO;

    public Test (int divide_into) {
        DIVIDE_INTO = divide_into;
    }

    public static double[] rand_array = new double[ARRAY_SIZE];

    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < rand_array.length; i++) {
            rand_array[i] = random.nextInt();
        }
    }

    public void test() {
        Test.fillArray();

        System.out.println("Array filled");

        int work_size = ARRAY_SIZE / DIVIDE_INTO;
        List<Watek> threads = new ArrayList<>(DIVIDE_INTO);

        for (int i = 0; i < DIVIDE_INTO; i++) {
            int start = i * work_size;
            int end = (i + 1) * work_size;
            Watek watek = new Watek(start, end, rand_array);
            threads.add(watek);
        }

        long startTime = System.nanoTime();
        threads.forEach(Thread::start);
        threads.forEach(watek -> {
            try {
                watek.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endTime = System.nanoTime();

        double max = 0;
        double min = 0;

        for (Watek watek : threads) {
            System.out.println(watek.getName() + " Max: " + watek.getMax() + " Min: " + watek.getMin());

            if (watek.getMax() > max) {
                max = watek.getMax();
            }
            if (watek.getMin() < min) {
                min = watek.getMin();
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            Test test = new Test(i);
            test.test();
        }
        Test test20 = new Test(20);
        test20.test();

        Test test100 = new Test(100);
        test100.test();

        Test test500 = new Test(100);
        test500.test();
    }
}
