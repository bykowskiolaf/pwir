package dev.bykowskiolaf.Lab5.Zad2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
public class Obliczenia extends Thread {
    private int result;
    private Dane dane1;
    private Dane dane2;
    private Semaphore semaphore;

    Obliczenia(Dane dane1, Dane dane2, Semaphore semaphore) {
        this.dane1 = dane1;
        this.dane2 = dane2;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = dane1.getLiczba() + dane2.getLiczba();
        System.out.println(result);
    }
}
