package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 */
public class KdiffPairs {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(nums, k));
    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(k == 0){
                if(entry.getValue() >= 2) count++;
            } else {
                if(map.containsKey(entry.getKey() + k)) count++;
            }
        }

        return count;
    }
}
