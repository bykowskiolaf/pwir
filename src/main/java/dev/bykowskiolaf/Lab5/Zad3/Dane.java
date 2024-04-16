package dev.bykowskiolaf.Lab5.Zad3;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
public class Dane extends Thread {

    private int liczba;
    private Semaphore dataSem, calcSem, iterSem;

    Dane(Semaphore dataSem, Semaphore calcSem, Semaphore iterSem) {
        this.dataSem = dataSem;
        this.calcSem = calcSem;
        this.iterSem = iterSem;
    }

    public void getDane() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(STR."Podaj daną dla \{Thread.currentThread().getName()}: ");
        liczba = scanner.nextInt();
        dataSem.release();
        calcSem.release();
    }

    @Override
    public void run() {
        while (iterSem.availablePermits() > 0) {
            try {
                dataSem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                iterSem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            getDane();
        }
    }
}
