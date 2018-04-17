package DynamicProgramming;

import java.util.HashSet;

/**
 * Given a set of number find the largest subset with contiguous elements
 */
public class LargestSubsetWithContiguousElements {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,14,2,4};
        System.out.println(findSubset(arr));
    }

    private static int findSubset(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int res = 0;

        for (int i : arr) {
            if(!set.contains(i-1)){
                // i is candidate for start of subsequence
                int temp = i;
                while(set.contains(temp)){
                    temp++;
                }
                res = Math.max(res, temp-i);

            }
        }

        return res;
    }
}
