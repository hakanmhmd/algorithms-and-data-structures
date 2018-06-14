package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 */
public class KdiffPairs {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(nums, k));
        System.out.println(findPairsPointers(nums, k));
    }

    private static int findPairs(int[] nums, int k) {
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

    private static int findPairsPointers(int[] nums, int k){
        Arrays.sort(nums);
        int i=0; int j = 1;
        int res = 0;
        while(j<nums.length){
            j = Math.max(i+1, j);
            while(j < nums.length && nums[j] - nums[i] < k){
                j++;
            }

            if(j<nums.length && nums[j] - nums[i] == k){
                res++;
            }

            i++;
            while(i<nums.length && nums[i] == nums[i-1]){
                i++;
            }
        }

        return res;

    }
}
