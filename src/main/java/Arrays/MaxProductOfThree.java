package Arrays;

import java.util.Arrays;

/**
 * Given an integer array, find a maximum product of a triplet in array.
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] input = {-1, 2, 3, -10, 20};
        System.out.println(maxProduct(input));
    }

    private static int maxProduct(int[] input) {
        Arrays.sort(input);
        int n = input.length;
        return Math.max(input[n-1]*input[n-2]*input[n-3], input[0]*input[1]*input[n-1]);
    }
}
