package DynamicProgramming;

import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be
 * formed in this fashion.
 *
 * Given a set of pairs, find the length longest chain which can be formed.
 * You needn't use up all the given pairs. You can select pairs in any order.
 */
public class MaxLengthOfPairChain {
    public static void main(String[] args) {
        int[][] pairs = {
                {2,3},
                {1,2},
                {3,4}
        };

        System.out.println(findLongestChainDP(pairs));
        System.out.println(findLongestChainGreedy(pairs));
    }

    private static int findLongestChainDP(int[][] pairs) {
        Arrays.sort(pairs, (a, b)->a[0]-b[0]);

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1); // min chain is always 1
        int max = Integer.MIN_VALUE;
        for(int i=1; i<pairs.length; i++){
            for (int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if(dp[i] > max) max = dp[i];
                }
            }
        }

        return max;
    }

    private static int findLongestChainGreedy(int[][] pairs){
        Arrays.sort(pairs, (a, b)->a[1]-b[1]);
        int max = 1;
        int[] lastPair = pairs[0];
        for(int i=1; i<pairs.length; i++){
            int[] pair = pairs[i];
            if(pair[0] > lastPair[1]){
                max++;
                lastPair = pair;
            }
        }

        return max;
    }
}
