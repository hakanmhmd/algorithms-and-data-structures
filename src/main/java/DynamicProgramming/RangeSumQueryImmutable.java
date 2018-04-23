package DynamicProgramming;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */
public class RangeSumQueryImmutable {
    static int[] helper;
    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        helper = new int[arr.length+1];

        helper[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            helper[i] = helper[i-1] + arr[i];
        }

        System.out.println(queryRange(1, 3));
        System.out.println(queryRange(0, 3));
        System.out.println(queryRange(1, 5));
    }

    // In this case original array is immutable
    private static int queryRange(int i, int j) {
        if(i == 0) return helper[j];
        return helper[j] - helper[i-1];
    }
}
