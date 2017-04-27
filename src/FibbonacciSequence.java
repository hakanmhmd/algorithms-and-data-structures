public class FibbonacciSequence {

    private static long[] cache = new long[200];
    private static long[] frequency = new long[200];

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        printFrequency();
    }

    // Dynamic programming implementation
    public static long fibonacci(int n){
        if(n == 0 || n == 1){
            frequency[n]++;
            cache[n] = n;
            return cache[n];
        }

        if (cache[n] == 0) {
            // number is not calculated yet
            cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        // increment frequency
        frequency[n]++;

        return cache[n];
    }

    public static void printFrequency(){
        for (int i = 0; i < frequency.length; i++) {
            long count = frequency[i];
            System.out.println("n = " + i + ", count = " + count);
        }
    }
}
