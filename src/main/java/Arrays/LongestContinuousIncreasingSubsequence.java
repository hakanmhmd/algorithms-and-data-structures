package Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,4,5,6,9,3,7,8,9};
        ArrayList<Integer> res = findContinuousIncreasingSubsequence(nums);
        Collections.reverse(res);
        System.out.println(res);
    }

    private static ArrayList<Integer> findContinuousIncreasingSubsequence(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(nums.length == 0) return result;
        int count = 1;
        int prev = nums[0];
        temp.add(prev);
        result = new ArrayList<>(temp);
        int max = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > prev){
                count++;
            } else {
                if(count > max) {
                    max = count;
                    result = new ArrayList<>(temp);
                    temp.clear();
                }
                count=1;
            }
            temp.add(nums[i]);
            prev = nums[i];
        }

        if(count > max) {
            max = count;
            result = new ArrayList<>(temp);
        }
        return result;
    }
}
