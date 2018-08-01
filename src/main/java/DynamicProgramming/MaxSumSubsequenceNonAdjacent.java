package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an array find the max subsequence sum from non adjacent elements
 */
public class MaxSumSubsequenceNonAdjacent {
    public static void main(String[] args) {
        int[] input = {4, 1, 1, 4, 2, 1};
        System.out.println(findSum(input));
        System.out.println(findSumExp(input));
        System.out.println(findSumDP(input));
    }

    // exponential
    private static int findSumExp(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];

        return Math.max(arr[0] + findSumExp(Arrays.copyOfRange(arr, 2, arr.length)),
                findSumExp(Arrays.copyOfRange(arr, 1, arr.length)));
    }

    // O(n) time, O(n) space
    private static int findSumDP(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = arr[0];
        for(int i=2; i<arr.length; i++){
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        return dp[arr.length-1];
    }

    private static int findSum(int[] input) {
        if(input==null || input.length==0) return 0;
        int exclusive = 0;
        int inclusive = input[0];

        for (int i = 1; i < input.length; i++) {
            int newInclusive = Math.max(inclusive, input[i] + exclusive);

            int temp = inclusive;
            inclusive = newInclusive;
            exclusive = temp;
        }

        return inclusive;
    }
}
