package DynamicProgramming;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {100, 4, 5, 1000};
        System.out.println(maxAmount(arr));
    }

    private static int maxAmount(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        if(arr.length==1) return arr[0];


        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++){
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length-1];
    }
}
