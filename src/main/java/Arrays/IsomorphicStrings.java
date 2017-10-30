package Arrays;

import java.util.Arrays;

/**
 * Two strings str1 and str2 are called isomorphic if there is a
 * one to one mapping possible for every character of str1 to every character of str2.
 * O(N)
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        boolean res = areIsomorphic("aab", "xxy");
        System.out.println(res);

        res = areIsomorphic("aab", "xyz");
        System.out.println(res);
    }

    private static boolean areIsomorphic(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        boolean[] marked = new boolean[256];
        int[] map = new int[256];
        Arrays.fill(map, -1);
        // can use HashMap
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            // c1 first time seen
            if(map[c1] == -1){
                // c2 is seen before
                if(marked[c2]){
                    return false;
                }
                marked[c2] = true;
                map[c1] = c2;
            } else { //c1 seen before
                if(map[c1] != c2){
                    return false;
                }
            }
        }
        return true;
    }
}
