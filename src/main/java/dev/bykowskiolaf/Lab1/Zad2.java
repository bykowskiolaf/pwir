package dev.bykowskiolaf.Lab1;

public class Zad2 {

    boolean checkIfPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Zad2 zad = new Zad2();

        System.out.println(zad.checkIfPrime(5));
    }
}
