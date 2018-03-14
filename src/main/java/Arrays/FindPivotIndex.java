package Arrays;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of
 * the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes,
 * you should return the left-most pivot index.
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot index: " + findPivot(arr));
    }

    private static int findPivot(int[] arr) {
        if(arr.length == 0) return -1;
        int[] prefixArray = new int[arr.length];
        prefixArray[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefixArray[i] = arr[i] + prefixArray[i-1];
        }

        int sum = prefixArray[prefixArray.length-1];

        for(int i=0; i<arr.length; i++){
            if(prefixArray[i] - arr[i] == sum - prefixArray[i]){
                return i;
            }
        }

        return -1;
    }
}
