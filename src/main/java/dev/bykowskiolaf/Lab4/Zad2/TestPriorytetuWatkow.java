package dev.bykowskiolaf.Lab4.Zad2;

public class TestPriorytetuWatkow {
    public static void main(String arg[]) {
        DzialajacyZiemniak2 dZ = new DzialajacyZiemniak2();
        Thread t1 = new Thread(dZ, "Pierwszy ziemniak");
        Thread t2 = new Thread(dZ, "Drugi ziemniak");
        Thread t3 = new Thread(dZ, "Trzeci ziemniak");
        Thread t4 = new Thread(dZ, "Czwarty ziemniak");
        t1.setPriority(1);
        t2.setPriority(3);
        t3.setPriority(6);
        t4.setPriority(10);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
