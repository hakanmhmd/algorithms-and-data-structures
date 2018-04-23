package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 */
public class SubsetsDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3};

        System.out.println(subsetsWithDup(arr));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        recurse(nums, res, 0, new ArrayList<>());
        return res;
    }

    private static void recurse(int[] nums, List<List<Integer>> res, int start, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);
            recurse(nums, res, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
