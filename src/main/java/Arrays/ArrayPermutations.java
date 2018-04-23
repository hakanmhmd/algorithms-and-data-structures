package Arrays;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of distinct integers, return all possible permutations.
 */
public class ArrayPermutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        ArrayList<int[]> permute = permute2(arr);
        for(int[] i: permute){
            System.out.println(Arrays.toString(i));
        }

        System.out.println(permute1(arr));
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static ArrayList<int[]> permute2(int[] arr) {
        ArrayList<int[]> res = new ArrayList<>();

        permute2(res, arr, 0);
        return res;
    }

    private static void permute2(ArrayList<int[]> res, int[] arr, int start) {
        if(start == arr.length){
            res.add(arr.clone());
            return;
        }

        for(int i=start; i<arr.length; i++){
            swap(arr, start, i);
            permute2(res, arr, start+1);
            swap(arr, i, start);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
