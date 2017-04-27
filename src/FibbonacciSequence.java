/*
    Implementation of fibonacci sequence with memoization
 */

public class FibbonacciSequence {

    private static long[] cache = new long[200];

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }


    public static long fibonacci(int n){
        if(n == 0 || n == 1){
            cache[n] = n;
            return cache[n];
        }

        if (cache[n] == 0) {
            // number is not calculated yet
            cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return cache[n];
    }
}
