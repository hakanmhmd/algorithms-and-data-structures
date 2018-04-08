package DynamicProgramming;

/**
 * Created by hakanmehmed on 23/10/2017.
 */
public class Fibonacci {
    public static void main (String args[]) {
        int n = 10;
        System.out.println(fib(n));
        System.out.println(fibDP(n, new int[n+1]));
        System.out.println(slowFib(n));
    }

    private static int slowFib(int n){
        if(n<=1) return n;
        return slowFib(n-1) + slowFib(n-2);
    }

    // space efficient
    private static int fib(int n) {
        int a = 0;
        int b = 1;
        int c;
        if (n == 0) return a;

        for(int i=2; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }

        return b;

    }

    // memoization
    // O(n) space
    private static int fibDP(int n, int[] memo) {
        if(n <= 1) return n;

        if(memo[n] == 0){
            memo[n] = fibDP(n-1, memo) + fibDP(n-2, memo);
        }

        return memo[n];

    }
}
