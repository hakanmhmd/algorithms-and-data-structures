package DynamicProgramming;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }

    private static int maxProduct(int[] arr) {
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];
        max[0] = min[0] = arr[0];
        int res = arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i] > 0){
                max[i] = Math.max(arr[i], max[i-1]*arr[i]);
                min[i] = Math.min(arr[i], min[i-1]*arr[i]);
            } else {
                max[i] = Math.max(arr[i], min[i-1]*arr[i]);
                min[i] = Math.min(arr[i], max[i-1]*arr[i]);
            }

            res = Math.max(res, max[i]);
        }

        return res;
    }
}
