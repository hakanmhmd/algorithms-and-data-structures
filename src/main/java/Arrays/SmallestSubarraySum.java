package Arrays;

/**
 * Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
 */
public class SmallestSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int k = 51;
        System.out.println(smallestSubArrayWithSum(arr, k));
    }

    private static int smallestSubArrayWithSum(int[] arr, int k) {
        int currSum = 0;
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while(end < arr.length){
            while(currSum <= k && end < arr.length){
                currSum += arr[end];
                end++;
            }


            while(currSum > k && start < arr.length){
                if(end - start < min) min = end - start;
                currSum -= arr[start];
                start++;
            }
        }

        return min;
    }


}
