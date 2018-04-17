package Arrays;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String s = "google";
        System.out.println(longestSubstring(s));

        s = "karappa";
        int m = 2;
        System.out.println(longestSubstringWithMUnique(s, m));
    }

    // addition: longest substring with m unique chars
    // karappa, 2 -> appa
    private static int longestSubstringWithMUnique(String s, int m){
        HashMap<Character, Integer> currentSubstring = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 1;
        currentSubstring.put(s.charAt(0), 1);

        int substringStart = 0;

        for(int i=1; i<s.length(); i++){
            if(currentSubstring.containsKey(s.charAt(i))){
                currentSubstring.put(s.charAt(i), currentSubstring.get(s.charAt(i)) + 1);
            } else {
                currentSubstring.put(s.charAt(i), 1);
            }
            end++;

            if(currentSubstring.size() > m){
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
            } else {
                if(end - start+1 > result){
                    result = end-start+1;
                    substringStart = start;
                }
            }
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

    /*
    public int lengthOfLongestSubstring(String s) {
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
     */
}
