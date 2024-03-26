package dev.bykowskiolaf.Lab4.Zad2;

public class DzialajacyZiemniak2
        implements Runnable{
    public void run(){
        while(true){
            System.out.println(Thread.
                    currentThread().getName());
            Thread.yield();
        }
    }
}
