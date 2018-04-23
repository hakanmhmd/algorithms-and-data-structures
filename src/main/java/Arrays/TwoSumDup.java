package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an unsorted array of integers, find all the pairs that they add up to a specific target number.
 * The array may contain duplicated elements.
 The output should not contain duplicated pairs, and each pair needs to be in ascending order,
 e.g., [1, 2] instead of [2, 1].
 */
public class TwoSumDup {
    public static void main(String[] args) {
        int[] arr = {1,0,3,3,2,1,2};
        int sum = 3;
        System.out.println(sums(arr, sum));
    }

    private static ArrayList<ArrayList<Integer>> sums(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int s = 0;
        int e = arr.length-1;

        while(s < e){
            int sum = arr[s] + arr[e];
            if(sum == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[s]);
                temp.add(arr[e]);
                res.add(temp);

                s++;
                e--;

                while(s<e && arr[s] == arr[s-1]) s++;
                while(s<e && arr[e] == arr[e+1]) e--;
            } else if(sum > target){
                e--;
            } else {
                s++;
            }
        }

        return res;
    }
}
