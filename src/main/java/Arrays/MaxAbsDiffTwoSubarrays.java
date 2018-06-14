package Arrays;

/**
 * Given an array of integers, find two non-overlapping contiguous sub-arrays such that the absolut
 * difference between the sum of two sub-arrays is maximum.
 * <p>
 * Input: [-2, -3, 4, -1, -2, 1, 5, -3]
 * Output: 12
 * Two subarrays are [-2, -3] and [4, -1, -2, 1, 5]
 * <p>
 * <p>
 * The idea is for each index i in given array arr[0…n-1], compute maximum and minimum sum subarrays
 * that lie in subarrays arr[0…i] and arr[i+1 …n-1]. We maintain four arrays that store the maximum
 * and minimum sums in the subarrays arr[0…i] and arr[i+1 … n-1] for every index i in the array.
 */
public class MaxAbsDiffTwoSubarrays {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(maxAbsDiff(arr));
    }

    private static int maxAbsDiff(int[] arr) {
        int maxSumSubarray = kadane(arr);
        for(int i=0; i<arr.length; i++){
            arr[i] = -1 * arr[i];
        }

        int minSumSubarray = -1 * kadane(arr);
        return Math.abs(minSumSubarray - maxSumSubarray);
    }

    private static int kadane(int[] a) {
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < a.length; i++) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }
}
