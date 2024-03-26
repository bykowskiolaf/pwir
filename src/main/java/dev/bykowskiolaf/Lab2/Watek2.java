package dev.bykowskiolaf.Lab2;

public class Watek2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
//            System.out.println(STR."\{Thread.currentThread().getName()}: \{i}");
            System.out.println(Thread.currentThread().getName() + ": " + i);

        }
    }
}
