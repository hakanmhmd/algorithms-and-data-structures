package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.
 */
public class AnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256];

        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int start = 0;
        int end = 0;
        int count = p.length();

        while(end < s.length()){
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if(hash[s.charAt(end)] >= 1){
                count--;
            }
            hash[s.charAt(end)]--;
            end++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if(count == 0){
                list.add(start);
            }

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if(end - start == p.length()){
                if(hash[s.charAt(start)] >= 0){
                    count++;
                }
                hash[s.charAt(start)]++;
                start++;
            }

        }

        return list;
    }
}
