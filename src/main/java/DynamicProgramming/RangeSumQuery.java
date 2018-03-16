package DynamicProgramming;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */
public class RangeSumQuery {
    static int[] helper;
    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        helper = new int[arr.length+1];

        for(int i=0; i<arr.length; i++){
            helper[i+1] = helper[i] + arr[i];
        }

        System.out.println(queryRange(1, 3));
        System.out.println(queryRange(0, 3));
        System.out.println(queryRange(1, 5));
    }

    private static int queryRange(int i, int j) {
        return helper[j+1] - helper[i];
    }
}
