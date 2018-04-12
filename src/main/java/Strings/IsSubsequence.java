package Strings;

import java.util.ArrayList;

/**
 * Given two strings str1 and str2, find if str1 is a subsequence of str2.
 * A subsequence is a sequence that can be derived from another sequence by deleting
 * some elements without changing the order of the remaining elements (source: wiki).
 * Expected time complexity is linear.
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String str1 = "AXY", str2 = "ADXCPAXY";
        System.out.println(isSubsequence(str1, str2, str1.length()-1, str2.length()-1));
        System.out.println(isSubsequence(str1, str2));
    }

    private static ArrayList<Integer> isSubsequence(String str1, String str2) {
        int m = str2.length();
        int n = str1.length();

        int i=0,j=0;
        ArrayList<Integer> indexes = new ArrayList<>();

        while(i < m) {
            if(str1.charAt(j) == str2.charAt(i)) {
                indexes.add(i);
                j += 1;
            }
            if(n == j) {
                j = 0;
            }
            i += 1;
        }

        return indexes;
    }


    private static boolean isSubsequence(String s1, String s2, int i, int j) {
        if(i == 0) return true;
        if(j == 0) return false;

        if(s1.charAt(i) == s2.charAt(j)) return isSubsequence(s1, s2, i-1, j-1);

        return isSubsequence(s1, s2, i, j-1);
    }
}
