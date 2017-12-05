package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array and a number x, check for pairs in the array with sum x
 *
 * 1) Use sorting and left/right pointers
 *    If x < (left+right) decrement right
 *    If x > (left+right) increment left
 *
 * 2) Use helper array or hashmap and check if (sum-arr[i]) is in as you go through the array
 */
public class PairSum {
    private static final int MAX = 10000;
    public static void main(String[] args) {
        int[] elements = {1, 3, 9, 11, 15, -3, 6, 6};
        int sum = 12;
        findPairs(elements, sum);
    }

    private static void findPairs(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int difference = sum - arr[i];

            if(set.contains(difference)){
                System.out.println("Pair (" + arr[i] + ", " + difference + ")");
            }
            set.add(arr[i]);
        }
    }
}
