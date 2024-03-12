package dev.bykowskiolaf.Lab1;

import java.security.SecureRandom;

public class Zad2 {

    boolean checkIfPrime(int number) {
        if (number < 2) {
            return false;
        }

        // 2 is the only even prime number
        for (int i = 2; i < number; i++) {
            // if the number is divisible by any number other than 1 and itself, it is not prime
            if (number % i == 0) {
                return false;
            }
        }

        // if the number is not divisible by any number other than 1 and itself, it is prime
        return true;
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        Zad2 zad = new Zad2();

        System.out.println(zad.checkIfPrime(random.nextInt(100)));
    }
}
