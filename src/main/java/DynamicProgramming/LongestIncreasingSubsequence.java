package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an array of random numbers. Find longest increasing subsequence (LIS) in the array
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 0, 6, 2, 3}; //-1,0,2,3
        int[] input = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        int m = findLIS(arr);
        int n = findLIS2(input);
        System.out.println(n);
    }

    // O(nlogn)
    private static int findLIS2(int[] arr) {
        int[] temp = new int[arr.length];
        int[] result = new int[arr.length];

        Arrays.fill(result, -1);
        temp[0] = 0;
        int len = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[temp[len]]){
                len++;
                temp[len] = i;
                result[temp[len]] = temp[len-1];
            } else if(arr[i] < arr[temp[0]]){
                temp[0] = i;
            } else { //do binary search to find ceiling for arr[i]
                int index = findCeil(arr, temp, len,arr[i]);
                temp[index] = i;
                result[temp[index]] = temp[index-1];
            }
        }
        int index = temp[len];
        while(index != -1) {
            System.out.print(arr[index] + " ");
            index = result[index];
        }

        System.out.println();
        return len+1;
    }

    private static int findCeil(int[] arr, int[] temp, int len, int i) {
        int left = 0;
        int right = len;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(arr[temp[mid]] < i && i <= arr[temp[mid+1]]){
                return mid+1;
            } else if(arr[temp[mid]] < i){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }

        return -1;
    }


    // O(n^2) solution
    private static int findLIS(int[] arr) {
        int[] helper = new int[arr.length];
        Arrays.fill(helper, 1);

        for (int i = 1; i < helper.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    helper[i] = helper[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < helper.length; i++) {
             max = Math.max(max, helper[i]);
        }
        return max;

    }
}
