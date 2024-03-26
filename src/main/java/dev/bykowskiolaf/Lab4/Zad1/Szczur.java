package dev.bykowskiolaf.Lab4.Zad1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Szczur extends Thread {
    private final Cake cake;

    public Szczur(final Cake cake, final String name) {
        super(name);
        this.cake = cake;
    }

//    private synchronized int eat(int percent) {
//        System.out.println(STR."\{Thread.currentThread()
//                .getName()} jem \{percent} torta.");
//        cake.percent = Math.max(cake.percent - percent, 0);
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(STR."\{Thread.currentThread()
//                .getName()} zostało \{cake.percent} torta.");
//        return cake.percent;
//    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (cake.eat(new Random().nextInt(40)) <= 0) {
                System.out.println("======KONIEC=======");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Cake cake = new Cake();
        Thread mouse1 = new Szczur(cake, "Szczuras 1");
        Thread mouse2 = new Szczur(cake, "Szczuras 2");
        System.out.println(STR."Szczuras 1=\{mouse1.getState()}");
        System.out.println(STR."Szczuras 2=\{mouse2.getState()}");
        mouse1.start();
        mouse2.start();
        do {
            System.out.println(STR."Szczuras 1=\{mouse1.getState()}");
            System.out.println(STR."Szczuras 4=\{mouse2.getState()}");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (mouse1.getState().ordinal()
                + mouse2.getState().ordinal() != 10);
    }
}
