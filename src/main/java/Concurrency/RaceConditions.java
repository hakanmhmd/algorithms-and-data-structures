package Concurrency;

import java.util.Objects;

/**
 * Created by hakanmehmed on 05/08/2018.
 */
public class RaceConditions {
    static class IntWrapper {
        private int n = 0;
        private final Object key = new Object();

        int getValue() {
            synchronized (key) {
                return n; //happens before link between increment() and getValue()
            }
        }

        void increment() {
            synchronized (key) {
                n += 1; // read and write op - possible race condition
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final IntWrapper n = new IntWrapper();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                n.increment();
            }
        };
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }


        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println(Thread.currentThread().getName() + " :value is " + n.getValue());
    }
}
