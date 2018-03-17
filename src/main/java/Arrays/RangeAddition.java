package Arrays;

import java.util.Arrays;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each
 * element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 */
public class RangeAddition {
    public static void main(String[] args) {
        int n = 5;
        int[][] q = {
                {1,  3,  2},
                {2,  4,  3},
                {0,  2, -2}
        };

        System.out.println(Arrays.toString(getModifiedArray(n, q)));

        int[][] q2 = {
                {1,  4,  4},
                {0,  2,  5}
        };

        System.out.println(Arrays.toString(getModifiedArray(n, q2)));

    }

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int[] update: updates){
            int start = update[0];
            int end = update[1];
            int val = update[2];

            arr[start] += val;
            if(end < length-1){
                arr[end+1] -= val;
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
    }
}
