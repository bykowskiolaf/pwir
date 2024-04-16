package dev.bykowskiolaf.Lab5.Zad2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore calcSem = new Semaphore(0);
        Semaphore dataSem = new Semaphore(1);

        Dane dane1 = new Dane(dataSem, calcSem);
        Dane dane2 = new Dane(dataSem, calcSem);
        Obliczenia obliczenia = new Obliczenia(dane1, dane2, calcSem);

        dane1.start();
        dane2.start();
        obliczenia.start();
    }
}
