package Concurrency;

/**
 * False sharing - because of the memory layout of CPU caches, there can occur false sharing (marking line of cache
 * dirty because of updating one value in the cache) between different cores which might lead to decreased performance
 */
public class FalseSharing {
    final static class VolatileLongPadded {
        public long q1, q2, q3, q4, q5, q6; //padding
        public volatile long value = 0L;
        public long q11, q12, q13, q14, q15, q16; //padding
    }

    final static class VolatileLongUnPadded {
        public volatile long value = 0L; //not padded - different instance fields will be in same cache line
    }

    private static VolatileLongPadded[] paddedLongs;
    private static VolatileLongUnPadded[] unpaddedLongs;

    static {
        paddedLongs = new VolatileLongPadded[4];
        for (int i = 0; i < paddedLongs.length; i++) {
            paddedLongs[i] = new VolatileLongPadded();
        }
        unpaddedLongs = new VolatileLongUnPadded[4];
        for (int i = 0; i < unpaddedLongs.length; i++) {
            unpaddedLongs[i] = new VolatileLongUnPadded();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        runBenchmark();
    }

    private static void runBenchmark() throws InterruptedException {
        long begin, end;
        for (int i = 1; i <= 4; i++) {
            Thread[] threads = new Thread[i];
            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            end = System.currentTimeMillis();
            System.out.println("Padded: " + (end - begin));


            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createUnPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            end = System.currentTimeMillis();
            System.out.println("UnPadded: " + (end - begin));
        }
    }

    private static Runnable createUnPaddedRunnable(int j) {
        return () -> {
            long i = 5000000;
            while (i != 0) {
                unpaddedLongs[j].value = i;
                i--;
            }
        };
    }

    private static Runnable createPaddedRunnable(int j) {
        return () -> {
            long i = 5000000;
            while (i != 0) {
                paddedLongs[j].value = i;
                i--;
            }
        };
    }
}
