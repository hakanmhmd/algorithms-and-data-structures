package Concurrency;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hakanmehmed on 08/08/2018.
 */
public class CacheWithReadWriteLock {
    private HashMap<Integer, String> cache = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();


    public String put(Integer key, String value){
        writeLock.lock();
        try{
            return cache.put(key, value);
        } finally {
            writeLock.unlock();
        }

    }

    public String get(Integer key){
        readLock.lock();
        try {
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        CacheWithReadWriteLock cache = new CacheWithReadWriteLock();

        class Producer implements Callable<Void> {
            private Random r = new Random();
            @Override
            public Void call() throws Exception {
                while(true){
                    int key = r.nextInt(1000);
                    cache.put(key, Integer.toString(key));
                    if(cache.get(key) == null){
                        System.out.println("Key " + key + " has not been put in the map.");
                    }
                }
            }
        }

        ExecutorService service = java.util.concurrent.Executors.newFixedThreadPool(4);
        try {
            for(int i=0; i<4; i++){
                service.submit(new Producer());
            }
        } finally {
            service.shutdown();
        }

    }
}
