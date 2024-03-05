package dev.bykowskiolaf.Lab1;

public class Zad1 {

    void hello() {
        System.out.println("Hello, World 1!");
    }

    void printTree(Integer height) {

        for (int i = 0; i < height; i++) {

            //prints out spaces before stars
            for (int j = height - i; j > 0; j--) {
                System.out.print(' ');
            }

            //prints out stars
            for (int k = 0; k < i; k++) {
                System.out.print("**");
            }

            System.out.println();
        }

        //prints out trunk
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < height - 1; j++)
                System.out.print(' ');
            System.out.println('#');
        }
    }

    public static void main(String[] args) {
        Zad1 zad1 = new Zad1();
        zad1.hello();
        zad1.printTree(5);
    }
}
