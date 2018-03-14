package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by hakanmehmed on 12/03/2018.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
   Each element in the array represents your maximum jump length at that position.
   Determine if you are able to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};

        System.out.println(canJumpGreedy(arr));
        System.out.println(canJumpBruteForce(arr));
        System.out.println(canJumpDP(arr));
    }

    // greedy solution
    private static boolean canJumpGreedy(int[] arr) {
        if(arr.length <= 1) return true;

        int lastGoodIndex = arr.length-1;
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i] + i >= lastGoodIndex){
                lastGoodIndex = i;
            }
        }

        return lastGoodIndex==0;
    }

    private static boolean canJumpBruteForce(int[] arr){
        return helper(0, arr);
    }

    private static boolean helper(int current, int[] arr) {
        if(current == arr.length-1) return true;

        int jump = current + arr[current];
        if(jump > arr.length-1) jump = arr.length-1;

        for(int i=current+1; i<=jump; i++){
            return helper(i, arr);
        }
        return false;
    }

    private static boolean canJumpDP(int[] arr){
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);

        memo[arr.length-1] = 1;
        return helper(0, arr, memo);
    }

    private static boolean helper(int current, int[] arr, int[] memo) {
        if(current == arr.length-1) return true;
        if(memo[current] != -1) {
            return memo[current] == 1;
        }


        int jump = current + arr[current];
        if(jump > arr.length-1) jump = arr.length-1;

        for(int i=current+1; i<=jump; i++){
            if(helper(i, arr, memo)){
                memo[current] = 1;
                return true;
            }
        }

        memo[current] = 0;
        return false;
    }
}
