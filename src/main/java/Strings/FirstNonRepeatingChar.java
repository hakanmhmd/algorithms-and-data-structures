package Strings;

import java.util.Arrays;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 */
public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstNonRepChar(s));
    }

    // o(n) time, o(1) space
    private static int firstNonRepChar(String s) {
        if(s.isEmpty()) return -1;
        int[] helper = new int[26]; // alphabet size
        Arrays.fill(helper, -1);
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if(helper[arr[i] - 'a'] == -1){
                helper[arr[i] - 'a'] = i;
            } else {
                helper[arr[i] - 'a'] = -2;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i : helper) {
            if(i >= 0 && i < minIndex){
                minIndex = i;
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
