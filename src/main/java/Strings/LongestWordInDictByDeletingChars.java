package Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Giving a dictionary and a string ‘str’, find the longest string in dictionary which can be formed by deleting
 * some characters of the given ‘str’.
 */
public class LongestWordInDictByDeletingChars {
    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"));
        String str = "abpcplea";

        System.out.println(longestDictWord(dict, str));
    }

    private static String longestDictWord(ArrayList<String> dict, String str) {
        String res = "";
        int len = Integer.MIN_VALUE;

        for(String word: dict){
            if(word.length() > len && isSubsequence(word, str)){
                res = word;
                len = word.length();
            }
        }

        return res;
    }

    private static boolean isSubsequence(String word, String str) {
        int j = 0;
        for(int i=0; i<str.length()&&j<word.length(); i++){
            if(word.charAt(j) == str.charAt(i)){
                j++;
            }
        }

        return (j==word.length());
    }
}
