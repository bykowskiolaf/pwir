package dev.bykowskiolaf.Lab5.Zad1;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
public class Obliczenia extends Thread {
    private int result;
    private Dane dane;
    private Semaphore semaphore;

    Obliczenia(Dane dane, Semaphore semaphore) {
        this.dane = dane;
        this.semaphore = semaphore;
    }

    public void calculate(int[] tab) {
        for (int j : tab) {
            result += j;
        }
        System.out.println("Wynik: " + result);
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("semaphore changed");
        calculate(dane.getTab());
    }
}
