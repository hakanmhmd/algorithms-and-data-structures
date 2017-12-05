package DynamicProgramming;

/**
 * Given an array find the max subsequence sum from non adjacent elements
 */
public class MaxSumSubsequenceNonAdjacent {
    public static void main(String[] args) {
        int[] input = {4, 1, 1, 4, 2, 1};
        int sum = findSum(input);
        System.out.println(sum);
    }

    private static int findSum(int[] input) {
        if(input==null || input.length==0) return 0;
        int inclusive = input[0];
        int exclusive = 0;

        for (int i = 1; i < input.length; i++) {
            int newInclusive = Math.max(inclusive, input[i] + exclusive);
            int newExclusive = inclusive;

            inclusive = newInclusive;
            exclusive = newExclusive;
        }

        return inclusive;
    }
}
