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
                    } else if (sum < target)
                        l++;
                    else // A[i] + A[l] + A[r] > sum
                        r--;
                }
            }
        }

        return result;
    }
}
