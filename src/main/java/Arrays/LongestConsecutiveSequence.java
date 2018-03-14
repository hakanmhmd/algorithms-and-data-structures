package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * [2,1,5,9,4,3] -> [1,2,3,4]
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {2,1,5,9,4,3};
        System.out.println(findLongestConsecutiveSequence(arr));
    }

    private static ArrayList<Integer> findLongestConsecutiveSequence(int[] arr) {
        if(arr == null || arr.length == 0) return null;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 1;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : arr) {
            int left = i-1;
            int right = i+1;
            int count = 1;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            while(set.contains(left)){
                count++;
                temp.add(left);
                set.remove(left);
                left--;
            }

            while(set.contains(right)){
                count++;
                temp.add(right);
                set.remove(right);
                right++;
            }

            if(count > max) {
                max = count;
                result = temp;
            }
        }

        return result;
    }
}
