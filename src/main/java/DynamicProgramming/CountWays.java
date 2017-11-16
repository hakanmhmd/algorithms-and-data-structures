package DynamicProgramming;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
public class CountWays {
    public static void main(String[] args) {
        int n = 7000;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(countWays(n, memo));
    }

    private static int countWays(int n, int[] memo) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(memo[n] == -1){
            memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
        }
        return memo[n];
    }
}
