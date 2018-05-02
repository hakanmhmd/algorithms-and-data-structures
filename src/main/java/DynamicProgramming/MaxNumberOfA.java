package DynamicProgramming;

import java.util.Arrays;

/**
 * Imagine you have a special keyboard with the following keys:
 Key 1:  Prints 'A' on screen
 Key 2: (Ctrl-A): Select screen
 Key 3: (Ctrl-C): Copy selection to buffer
 Key 4: (Ctrl-V): Print buffer on screen appending it
 after what has already been printed.

 If you can only press the keyboard for N times (with the above four
 keys), write a program to produce maximum numbers of A's. That is to
 say, the input parameter is N (No. of keys that you can press), the
 output is M (No. of As that you can produce).
 */
public class MaxNumberOfA {
    public static void main(String[] args) {
        int N = 11;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        System.out.println(maxAs(N, dp));
    }

    // observation
    // n<= 6 return n
    // n > 6 The sequence of N keystrokes which produces an optimal string length will end with
    // a suffix of Ctrl-A, a Ctrl-C, followed by only Ctrl-V's
    // https://www.youtube.com/watch?v=nyR8K63F2KY
    private static int maxAs(int n, int[] dp) {
        if(n < 0) return -1;

        if(n <= 6) return n;
        int multiplier = 2;
        int max = 0;

        for(int i=n-3; i>=1; i--){
            if(dp[i] == -1){
                dp[i] = maxAs(i, dp);
            }

            max = Math.max(max, multiplier * dp[i]);
            multiplier++;
        }
        return max;
    }
}
