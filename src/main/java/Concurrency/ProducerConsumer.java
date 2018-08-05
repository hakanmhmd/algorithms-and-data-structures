package Concurrency;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by hakanmehmed on 05/08/2018.
 */
public class ProducerConsumer {
    private static final Object lock = new Object();
    private static int[] buffer;
    private static int count;
    private static Random rand = new Random();

    static class Producer {
        void produce() throws InterruptedException {
            synchronized (lock) {
                if (isFull(buffer)) {
                    lock.wait();
                }
                buffer[count++] = rand.nextInt();
                lock.notifyAll();
            }
        }
    }

    static class Consumer {
        void consume() throws InterruptedException {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    lock.wait();
                }
                buffer[--count] = 0;
                lock.notifyAll();
            }
        }
    }

    private static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    private static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;

        Producer p = new Producer();
        Consumer c = new Consumer();

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done producing");
        };

        Runnable consumeTask = () -> {
            for (int i = 0; i < 45; i++) {
                try {
                    c.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done consuming");
        };

        Thread t1 = new Thread(produceTask);
        Thread t2 = new Thread(consumeTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Buffer: " + Arrays.toString(buffer) + ", " + count);
    }

}
