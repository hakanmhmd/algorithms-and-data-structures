package DynamicProgramming;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 */
public class CountNumberOfSetBits {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        if(num == 0) return dp;
        dp[1] = 1;
        if(num == 1) return dp;
        int currentPower = 2;
        int prevPower = 1;
        for(int i=2; i<=num; i++){
            if(i == currentPower){
                dp[i] = 1;
                prevPower = currentPower;
                currentPower *= 2;
            } else {
                dp[i] = 1 + dp[i-prevPower];
            }
        }

        return dp;
    }
}
