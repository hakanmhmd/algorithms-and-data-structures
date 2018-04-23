package Strings;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the 
 * characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"

 Minimum window is "BANC".
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int index = 0;

        while(end < s.length()){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) counter--;
            }

            end++;

            while(counter == 0){
                char temp = s.charAt(start);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp)+1);
                    if(map.get(temp) > 0) counter++;
                }

                if(end-start < len) {
                    len = end-start;
                    index = start;
                }
                start++;
            }

        }

        if(len == Integer.MAX_VALUE) return "";
        return s.substring(index, index+len);
    }
}
