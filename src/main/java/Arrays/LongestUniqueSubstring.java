package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String s = "karappa";
        int m = 2;
        System.out.println(longestSubstringWithMUnique(s, m));

        s = "google";
        System.out.println(longestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring3(s));
    }

    // addition: longest substring with m unique chars
    // karappa, 2 -> appa
    private static int longestSubstringWithMUnique(String s, int m){
        if(s==null || s.length() == 0 || m == 0) return 0;
        if(s.length() < m) return s.length();

        HashMap<Character, Integer> currentSubstring = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 1;

        int substringStart = 0;

        while(end < s.length()){
            if(currentSubstring.containsKey(s.charAt(end))){
                currentSubstring.put(s.charAt(end), currentSubstring.get(s.charAt(end)) + 1);
            } else {
                currentSubstring.put(s.charAt(end), 1);
            }

            if(currentSubstring.size() > m){
                if(end - start > result){
                    result = end-start;
                    substringStart = start;
                }
                // start removing from start
                while(currentSubstring.size() > m){
                    int count = currentSubstring.get(s.charAt(start));
                    if(count == 1){
                        currentSubstring.remove(s.charAt(start));
                    } else {
                        currentSubstring.put(s.charAt(start), count-1);
                    }
                    start++;
                }
            }

            end++;
        }

        if(end - start > result){
            result = end-start;
            substringStart = start;
        }

        System.out.println(s.substring(substringStart, substringStart + result));

        return result;

    }

    private static int longestSubstring(String s) {
        if(s==null) {
            return 0;
        }
        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                if(result < i-start){
                    result = i-start;
                    res = s.substring(start, i);
                }
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        if(result < arr.length-start){
            result = arr.length-start;
            res = s.substring(start, arr.length);
        }
        System.out.println(res);

        return result;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


    public static int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            // > 0 means repeating character
            //if(map[s.charAt(end++)]-- > 0) counter++;
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) counter++;
            end++;

            while (counter > 0) {
                //if (map[s.charAt(begin++)]-- > 1) counter--;
                char charTemp = s.charAt(begin);
                if (map.get(charTemp) > 1) counter--;
                map.put(charTemp, map.get(charTemp)-1);
                begin++;
            }
            d = Math.max(d, end - begin);
        }
        return d;
    }

}
