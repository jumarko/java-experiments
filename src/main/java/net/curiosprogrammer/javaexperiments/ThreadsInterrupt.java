package net.curiosprogrammer.javaexperiments;

import java.util.Date;

/**
 * Explore what happens to child threads when the thread that launch them is interrupted.
 * => nothing, they live happily ever after.
 */
public class ThreadsInterrupt {

    static Thread child = null;

    public static void main(String[] args) throws InterruptedException {

        Thread parent = new Thread(() -> {
            System.out.println("Parent is running");
            child = new Thread(() -> {
                System.out.println("Child is running");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Child finished: " + new Date());
            });
            child.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Parent finished: " + new Date());
        });
        parent.start();
        Thread.sleep(1000);
        System.out.println("Interrupting parent");
        // notice that only parent is interrupted and child is happily going on until it's finished (~ 9 more seconds)
        // ...
        //   Parent finished: Sat Jul 11 15:50:48 CEST 2020
        //   Child finished: Sat Jul 11 15:50:57 CEST 2020
        parent.interrupt();
        System.out.println("parent interrupted");

    }
}
