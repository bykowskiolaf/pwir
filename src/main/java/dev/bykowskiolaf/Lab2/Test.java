package dev.bykowskiolaf.Lab2;

public class Test {
    public static void main(String[] args) {
        Watek1 watek1 = new Watek1();
        Watek2 watek2 = new Watek2();

        watek1.setName("Watek1");
        System.out.println(watek1.getName());

        watek1.start();
        watek2.start();
    }
}
