package dev.bykowskiolaf.Lab5.Zad1;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
public class Dane extends Thread {

    private int[] tab;
    private Semaphore semaphore;

    Dane(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void getDane() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rozmiar tablicy: ");
        int n = scanner.nextInt();
        tab = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println(STR."Podaj \{i} element tablicy: ");
            tab[i] = scanner.nextInt();
        }
        semaphore.release();
    }

    @Override
    public void run() {
        getDane();
    }
}
