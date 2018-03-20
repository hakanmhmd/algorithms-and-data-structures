package Arrays;

/**
 * Given an array containing n numbers. The problem is to find the length of the longest contiguous
 * subarray such that every element in the subarray is strictly greater than its previous
 * element in the same subarray. Time Complexity should be O(n).
 */
public class LongestIncreasingSubarray {
    public static void main(String[] args) {
        int arr[] = {5, 6, 3, 5, 7, 8, 9, 1, 2};
        int n = arr.length;
        System.out.println("Length = " +
                lenOfLongIncSubArr(arr));

    }

    private static int lenOfLongIncSubArr(int[] arr) {
        int max = 1;
        int len = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[i-1]){
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max ,len);
        return max;
    }
}
