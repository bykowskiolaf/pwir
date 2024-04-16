package dev.bykowskiolaf.Lab5.Zad1;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);

        Dane dane = new Dane(semaphore);
        dane.start();
        Obliczenia obliczenia = new Obliczenia(dane, semaphore);
        obliczenia.start();
    }
}
