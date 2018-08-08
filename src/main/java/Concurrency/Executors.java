package Concurrency;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

/**
 * Created by hakanmehmed on 06/08/2018.
 */
public class Executors {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //Runnable task = () -> System.out.println("Thread: " + Thread.currentThread().getName());
        Callable<String> task = () -> "Thread: " + Thread.currentThread().getName();
        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(4);


        Callable<String> excp = () -> {
            throw new IllegalArgumentException();
        };

        try {
            for (int i = 0; i < 10; i++) {
                Future<String> future = executorService.submit(task);
                System.out.println(future.get(100, TimeUnit.MILLISECONDS));
            }

            Future<String> future = executorService.submit(excp);
            System.out.println(future.get());

        } finally {
            executorService.shutdown();
        }

    }
}