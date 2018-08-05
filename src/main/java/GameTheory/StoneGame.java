package GameTheory;

import java.util.Arrays;

/**
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row,
 * and each pile has a positive integer number of stones piles[i].

 The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

 Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones
 from either the beginning or the end of the row.  This continues until there are no more piles left,
 at which point the person with the most stones wins.

 Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.

 dp[i][j] shows the max difference between number of your stones and opponents stones
 you can piles[i] or piles[j]
 */
public class StoneGame {
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        System.out.println(stoneGame(piles));
    }

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) dp[i][i] = piles[i];

        for(int gap=1; gap<n; gap++){
            for(int i=0; i<n-gap; i++){
                int j = i+gap;
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }

        return dp[0][n-1] > 0;
    }

    // O(N) space
    public boolean stoneGame2(int[] p) {
        int[] dp = Arrays.copyOf(p, p.length);;
        for (int d = 1; d < p.length; d++)
            for (int i = 0; i < p.length - d; i++)
                dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
        return dp[0] > 0;
    }
}
