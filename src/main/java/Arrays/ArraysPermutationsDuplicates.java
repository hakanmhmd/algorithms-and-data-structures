package Arrays;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class ArraysPermutationsDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,2};

        System.out.println(permutations(arr));
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(list, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
