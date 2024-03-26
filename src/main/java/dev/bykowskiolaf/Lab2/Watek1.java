package dev.bykowskiolaf.Lab2;

public class Watek1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
//            System.out.println(STR."\{Thread.currentThread().getName()}: \{i}");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
