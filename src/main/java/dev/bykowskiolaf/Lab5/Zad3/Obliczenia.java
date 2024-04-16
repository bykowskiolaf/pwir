package dev.bykowskiolaf.Lab5.Zad3;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
public class Obliczenia extends Thread {
    private int result;
    private Dane dane1;
    private Dane dane2;
    private Semaphore calcSem, iterSem;

    Obliczenia(Dane dane1, Dane dane2, Semaphore calcSem, Semaphore iterSem) {
        this.dane1 = dane1;
        this.dane2 = dane2;
        this.calcSem = calcSem;
        this.iterSem = iterSem;
    }

    @Override
    public void run() {
        while (iterSem.availablePermits() > 0) {
            try {
                calcSem.acquire(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            result = dane1.getLiczba() + dane2.getLiczba();
            System.out.println(STR."Wynik \{result}");
        }
    }
}
