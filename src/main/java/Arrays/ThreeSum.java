package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hakanmehmed on 02/03/2018.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] s = new int[]{1, 0, -1, 0, 2, -1, 4};
        int target = 0;
        ArrayList<ArrayList<Integer>> solutions = threeSum(s, target);
        System.out.println(solutions);

        System.out.println(threeSumClosest(s, 8));

        int[] arr = {-2, 0, 1, 3};
        int t = 2;
        System.out.println(threeSumSmaller(arr, t));
    }

    private static ArrayList<ArrayList<Integer>> threeSum(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(input == null || input.length < 3) return result;

        Arrays.sort(input);
        System.out.println(Arrays.toString(input));
        for (int i = 0; i < input.length-2; i++) {
            if(i == 0 || input[i] > input[i-1]) {
                int l = i + 1; // index of the first element in the
                int r = input.length - 1; // index of the last element
                while (l < r) {
                    int sum = input[i] + input[l] + input[r];
                    if (sum == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(input[i]);
                        list.add(input[l]);
                        list.add(input[r]);
                        result.add(list);
                        l++;
                        r--;

                        while (l < r && input[l] == input[l - 1])
                            l++;
                        while (l < r && input[r] == input[r + 1])
                            r--;
                    } else if (sum < target) {
                        l++;
                    } else { // A[i] + A[l] + A[r] > target
                        r--;
                    }
                }
            }
        }

        return result;
    }

    //Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
    // that satisfy the condition nums[i] + nums[j] + nums[k] < target.
    private static ArrayList<ArrayList<Integer>> threeSumSmaller(int[] nums, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            int l = i+1;
            int r = nums.length-1;

            while(l<r){
                if(nums[i] + nums[l] + nums[r] < target){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);

                    int k = r;
                    for(int j=k-1; j>l; j--){
                        ArrayList<Integer> newAl = new ArrayList<>();
                        newAl.add(nums[i]);
                        newAl.add(nums[l]);
                        newAl.add(nums[j]);
                        res.add(newAl);
                    }

                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }

    private static int threeSumClosest(int[] nums, int target){
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1;
            int r = nums.length-1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(sum - target);

                if (diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }

        }

        return result;
    }
}
