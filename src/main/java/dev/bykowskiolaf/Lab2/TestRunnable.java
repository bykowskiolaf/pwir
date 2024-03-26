package dev.bykowskiolaf.Lab2;

public class TestRunnable {
    public static void main(String[] args) {
        Watek1Runnable watek1 = new Watek1Runnable();
        Watek2Runnable watek2 = new Watek2Runnable();

        Thread thread1 = new Thread(watek1);
        Thread thread2 = new Thread(watek2);

        thread1.start();
        thread2.start();
    }
}
