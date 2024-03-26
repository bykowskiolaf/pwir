package dev.bykowskiolaf.Lab3.Zad3;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Silnia {
    private class Watek extends Thread {
        private BigInteger liczba;
        private Silnia silnia;

        @Override
        public void run() {
            System.out.println(STR."\{Thread.
                    currentThread().getName()}[\{liczba}] ! = \{silnia.licz(liczba)}");
        }
    }

    public BigInteger licz(BigInteger wartosc) {
        if (wartosc.equals(BigInteger.ZERO) || wartosc.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else
            return wartosc.multiply(licz(wartosc.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int liczba = sc.nextInt();
        sc.close();

        Silnia silnia = new Silnia();
        Watek watek = silnia.new Watek();
        watek.silnia = silnia;
        watek.liczba = BigInteger.valueOf(liczba);
        watek.start();
    }
}
