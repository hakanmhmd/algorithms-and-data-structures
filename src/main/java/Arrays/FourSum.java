package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourSum {
    public static void main(String[] args) {
        int[] s = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        ArrayList<ArrayList<Integer>> solutions = fourSum(s, target);
        System.out.println(solutions);
    }

    private static ArrayList<ArrayList<Integer>> fourSum(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(input == null || input.length < 4) return result;

        Arrays.sort(input);

        for (int i = 0; i < input.length-3; i++) {
            if(i!=0 && input[i]==input[i-1]) continue;
            for (int j = i+1; j < input.length-2; j++) {
                if(j!=i+1 && input[j]==input[j-1]) continue;
                int l = j+1;
                int r = input.length-1;
                while(l<r){
                    if(input[i] + input[j] + input[l] + input[r] == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(input[i]);
                        list.add(input[j]);
                        list.add(input[l]);
                        list.add(input[r]);
                        result.add(list);

                        l++;
                        r--;

                        while(l<r && input[r]==input[r+1]){
                            r--;
                        }
                        while(l<r && input[l]==input[l-1]){
                            l++;
                        }

                    } else if(input[i] + input[j] + input[l] + input[r] < target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }

        }

        return result;
    }
}
