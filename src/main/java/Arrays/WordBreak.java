package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 For example, given s = "leetcode", dict = ["leet", "code"].
 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");

        String s ="leetcode";

        System.out.println(wordBreak(s, set));
    }

    private static boolean wordBreak(String s, Set<String> set) {
        int n = s.length();

        boolean[] f = new boolean[n+1];
        f[0] = true;

        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(!f[j]) continue;
                String prefix = s.substring(j, i);

                if(set.contains(prefix)){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }
}
