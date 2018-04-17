package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a set of numbers and target sum return true if any subset of these numbers can sum up to the target
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1,3,6,9};
        int target = 9;

        System.out.println(subsetSumRecursive(arr, target, 0));
        System.out.println(subsetSum(arr, target));

        arr = new int[]{1, -3, 2, 4};
        target = 0;
        System.out.println(subsetSumNegativeDP(arr, target));
    }

    private static boolean subsetSumRecursive(int[] arr, int target, int current) {
        if(target == 0) return true;
        if(current == arr.length) return false;

        // if current element is greater exclude it
        if(arr[current] > target) return subsetSumRecursive(arr, target, current+1);

        // try including current value and excluding current value
        return subsetSumRecursive(arr, target-arr[current], current+1) || subsetSumRecursive(arr, target, current+1);
    }

    private static boolean subsetSumNegativeDP(int[] arr, int target){
        int maxSumPossible = 0;
        int minSumPossible = 0;
        for(int i: arr) {
            if(i > 0) maxSumPossible += i;
            if(i < 0) minSumPossible += i;
        }
        int rows = arr.length;
        int[] cols = new int[maxSumPossible - minSumPossible + 1];
        int temp = minSumPossible;
        HashMap<Integer, Integer> map = new HashMap<>();//num to index
        for(int i=0; i<cols.length; i++){
            cols[i] = temp;
            map.put(temp, i);
            temp++;
        }
        System.out.println(Arrays.toString(cols));
        boolean[][] dp = new boolean[rows][cols.length];

        for(int i=0; i<rows; i++){
            int num = arr[i];
            for(int j=0; j<cols.length; j++){
                if(cols[j] == num) {
                    dp[i][j] = true;
                } else {
                    if(i != 0) {
                        dp[i][j] = dp[i - 1][j];
                        if(map.containsKey(cols[j]-num)){
                            dp[i][j] = dp[i][j] || dp[i - 1][map.get(cols[j]-num)];
                        }
                    }
                }
            }
        }

        for(boolean[] a: dp){
            System.out.println(Arrays.toString(a));
        }

        return dp[rows-1][target];


    }

    // works only for positive numbers
    private static boolean subsetSum(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length+1][target+1];

        // if subset if empty we cant sum up to target
        for(int i=1; i<=target; i++){
            dp[0][i] = false;
        }

        // if target is 0 we can get by taking the empty subset
        for(int i=0; i<=arr.length; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<=arr.length; i++){
            for(int j=1; j<=target; j++){
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][target];
    }
}
