package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an array of jumps we can take, what is the minimum number of jumps to reach end of array
 */
public class MinJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {1,4,3,7,1,2,6,7,6,10};
        System.out.println(minJumps(arr));
        System.out.println(minJumps2(arr));
    }

    // O(n^2)
    private static int minJumps(int[] arr) {
        int[] dp = new int[arr.length];
        dp[arr.length-1] = 1;

        for(int i=arr.length-2; i>=0; i--){
            if(i + arr[i] >= arr.length){
                dp[i] = 1;
            } else {
                int jumps = arr[i];
                int min = Integer.MAX_VALUE;
                int index = i+1;
                while(jumps > 0 && index < arr.length){
                    min = Math.min(min, dp[index]);
                    index++;
                    jumps--;
                }
                dp[i] = min + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    // O(n)
    private static int minJumps2(int[] arr){
        int ladder = arr[0]; // keep the next ladder to jump on
        int steps = arr[0]; // number of steps on the current ladder
        int jumps = 1;

        for(int i=1; i<arr.length; i++){
            if(i >= arr.length-1) return jumps;
            ladder = Math.max(ladder, i + arr[i]);
            steps--;
            if(steps == 0){
                jumps++;
                steps = ladder - i; // jump on the new ladder
            }
        }

        return jumps;
    }

}
