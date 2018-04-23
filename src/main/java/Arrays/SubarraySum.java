package Arrays;

import java.util.HashMap;

/**
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 */
public class SubarraySum {
    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        subarraySum(arr, sum);

        arr = new int[]{10, -2, -20, 10};
        sum = -10;
        subarraySumNegatives(arr, sum);
    }

    private static void subarraySum(int[] arr, int sum) {
        int start=0;
        int end=0;
        int currSum = 0;

        while(end < arr.length){
            currSum += arr[end];
            end++;
            while(currSum > sum && start < arr.length){
                currSum -= arr[start];
                start++;
            }
            if(currSum == sum){
                System.out.println("Between " + start + " and " + (end-1));
                return;
            }

        }
    }

    private static void subarraySumNegatives(int[] arr, int sum) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        int currSum = 0;

        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            if(currSum == sum) {
                System.out.println("Between 0 and " + i);
                return;
            }

            if(sums.containsKey(currSum - sum)){
                System.out.println("Between " + (sums.get(currSum-sum)+1) + " and " + i);
                return;
            }
            sums.put(currSum, i);
        }

    }
}
