package dev.bykowskiolaf.Lab3.Zad1;

import java.util.Objects;
import java.util.Random;

public class Watek extends Thread {

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " " + i);
            if (Objects.equals(getName(), "Watek1"))
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            else {
                try {
                    sleep(random.nextInt(0, 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
