package DynamicProgramming;

import java.util.Arrays;

/**
 * Given some coin denominations what is the minimum number of coin to get a target number
 * assuming there is infinite supply of coins
 */
public class CoinChangingProblem {
    public static void main(String[] args) {
        int[] coins = {5,2,8,6};
        int target = 11;

        int minNumberOfCoins = findMinCoins2(coins, target);
        System.out.println(minNumberOfCoins);
    }

    private static int findMinCoins2(int[] coins, int target) {
        int[] T = new int[target+1];
        int[] R = new int[target+1];


        for (int i = 0; i <= target; i++) {
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        T[0] = 0;


        for (int i = 0; i < coins.length; i++) {
            int thisCoin = coins[i];
            for (int j = 1; j <= target; j++) {
                if(j >= thisCoin){
                    if(T[j-thisCoin] + 1 < T[j]){
                        T[j] = T[j-thisCoin] + 1;
                        R[j] = i;
                    }
                }
            }
        }

        if(R[R.length-1] == -1){
            System.out.println("No solution");
            return -1;
        }

        int start = R.length-1;
        while(start!=0){
            System.out.print(coins[R[start]] + " ");
            start = start - coins[R[start]];
        }
        System.out.println();

        return T[T.length-1];
    }

    private static int findMinCoins(int[] coins, int target) {
        int[][] matrix = new int[coins.length+1][target+1];
        for (int i = 0; i < target+1; i++) {
            matrix[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length+1; i++) {
            matrix[i][0] = 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(j >= coins[i-1] && matrix[i][j-coins[i-1]] != Integer.MAX_VALUE){
                    matrix[i][j] = Math.min(1 + matrix[i][j-coins[i-1]], matrix[i-1][j]);
                } else {
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        return matrix[coins.length][target];
    }


}
