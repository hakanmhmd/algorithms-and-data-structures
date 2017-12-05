package Arrays;

/**
 * Given an array arr[] of integers, find out the difference between any two elements such that
 * larger element appears after the smaller number in arr[].
 */
public class MaxDifference {
    public static void main(String[] args) throws Exception {
        int arr[] = {10, 2, 90, 10, 110, 1, 100};
        System.out.println("Maximum differnce is " +
                maxDiff(arr, 5));
    }

    private static int maxDiff(int[] arr, int i) throws Exception {
        if(arr.length < 2) {
            throw new Exception();
        }

        int maxDiff = Integer.MIN_VALUE;
        int minElement = arr[0];

        for (int j = 1; j < arr.length; j++) {
            if(arr[j] - minElement > maxDiff){
                maxDiff = arr[j] - minElement;
            }
            if(arr[j] < minElement){
                minElement = arr[j];
            }
        }
        return maxDiff;
    }
}
