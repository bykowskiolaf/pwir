package dev.bykowskiolaf.Lab5.Zad3;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore calcSem = new Semaphore(0);
        Semaphore dataSem = new Semaphore(1);
        Semaphore iterSem = new Semaphore(6);

        Dane dane1 = new Dane(dataSem, calcSem, iterSem);
        Dane dane2 = new Dane(dataSem, calcSem, iterSem);
        Obliczenia obliczenia = new Obliczenia(dane1, dane2, calcSem, iterSem);

        dane1.start();
        dane2.start();
        obliczenia.start();
    }
}
