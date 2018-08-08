package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hakanmehmed on 07/08/2018.
 */
public class ProducerConsumerLocks {

    private static ArrayList<Integer> buffer = new ArrayList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition isEmpty = lock.newCondition();
    private static Condition isFull = lock.newCondition();


    static class Producer implements Callable<String> {
        @Override
        public String call() throws Exception {
            int count = 0;
            while(count++ < 50){
                try{
                    lock.lock();
                    while(buffer.size() > 50){
                        //wait
                        isEmpty.await();
                    }
                    buffer.add(1);
                    isFull.signal();
                } finally {
                    lock.unlock();
                }
            }
            return "Produced: " + (count-1);
        }
    }

    static class Consumer implements Callable<String> {
        @Override
        public String call() throws Exception {
            int count = 0;
            while(count++ < 50){
                try {
                    lock.lock();
                    while (buffer.isEmpty()) {
                        //wait
                        isFull.await(10, TimeUnit.MILLISECONDS);
                    }
                    buffer.remove(buffer.size() - 1);
                    //signal
                    isEmpty.signal();
                } finally {
                    lock.unlock();
                }
            }
            return "Consumed: " + (count-1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Producer> producers = new ArrayList<>();
        for(int i=0; i<4; i++) producers.add(new Producer());
        List<Consumer> consumers = new ArrayList<>();
        for(int i=0; i<4; i++) consumers.add(new Consumer());

        List<Callable<String>> producersAndConsumers = new ArrayList<>();
        producersAndConsumers.addAll(producers);
        producersAndConsumers.addAll(consumers);

        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(5);
        try {
            List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);
            futures.forEach(future -> {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            executorService.shutdown();
        }
    }
}
