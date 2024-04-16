package dev.bykowskiolaf.Lab5.Zad2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
public class Dane extends Thread {

    private int liczba;
    private Semaphore dataSem, calcSem;

    Dane(Semaphore dataSem, Semaphore calcSem) {
        this.dataSem = dataSem;
        this.calcSem = calcSem;
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
        try {
            dataSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getDane();
    }
}
