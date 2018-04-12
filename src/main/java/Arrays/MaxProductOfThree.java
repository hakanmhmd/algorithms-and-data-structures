package Arrays;

import java.util.Arrays;

/**
 * Given an integer array, find a maximum product of a triplet in array.
 *
 *
 * What if we wanted the highest product of 4 items?
 * What if we wanted the highest product of kk items?
 * If our highest product is really big, it could overflow. ↴ How should we protect against this?
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] input = {-1, 2, 3, -10, 20};
        System.out.println(maxProduct(input));
        System.out.println(maxProduct2(input));
    }

    // O(nlogn)
    private static int maxProduct(int[] input) {
        Arrays.sort(input);
        int n = input.length;
        return Math.max(input[n-1]*input[n-2]*input[n-3], input[0]*input[1]*input[n-1]);
    }

    // O(n) single scan - no need to sort
    private static int maxProduct2(int[] input) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i : input) {
            if(i<=min1){
                min2 = min1;
                min1 = i;
            } else if(i<=min2){
                min2=i;
            }

            if(i>=max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if(i>=max2){
                max3 = max2;
                max2 = i;
            } else if(i>=max3){
                max3 = i;
            }
        }

        return Math.max(max1*max2*max3, min1*min2*max1);
    }

}
