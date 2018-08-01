package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
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

        s = "catsanddog";
        ArrayList<String> list = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(wordBreak2(s, list));
    }

    private static boolean wordBreak(String s, Set<String> set) {
        int n = s.length();

        boolean[] f = new boolean[n+1];
        f[0] = true;

        // can prune if the string in consideration becomes longer than the longest string in dict
        // j = i-1; j>=max(0, i-maxlen); j--
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<=i-1; j++){
                if(!f[j]) continue;
                String prefix = s.substring(j, i);
                //System.out.println(prefix);
                if(set.contains(prefix)){
                    f[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(f));

        return f[n];
    }

    /*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces
    in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary
     does not contain duplicate words.

    Return all such possible sentences.

    For example, given
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].

    A solution is ["cats and dog", "cat sand dog"].
     */

    private static ArrayList<String> wordBreak2(String s, ArrayList<String> wordDict){
        ArrayList<Integer>[] starting = new ArrayList[s.length()+1];
        starting[0] = new ArrayList<>();

        int maxLen = Integer.MIN_VALUE;
        for (String s1 : wordDict) {
            maxLen = Math.max(maxLen, s1.length());
        }
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j>=i-maxLen && j>=0; j--){
                if(starting[j] == null) continue;
                String word = s.substring(j, i);
                if(wordDict.contains(word)){
                    if(starting[i] == null){
                        starting[i] = new ArrayList<>();
                    }
                    starting[i].add(j);
                }
            }
        }

        ArrayList<String> rst = new ArrayList<>();
        if(starting[s.length()] == null)
            return rst;

        dfs(rst, "", s, starting, s.length());
        return rst;
    }

    private static void dfs(ArrayList<String> rst, String curr, String s, ArrayList<Integer>[] starting, int end) {
        if(end == 0){
            rst.add(curr.substring(1));
            return;
        }

        ArrayList<Integer> list = starting[end];
        for(Integer i : list){
            String word = s.substring(i, end);
            dfs(rst, " " + word + curr, s, starting, i);
        }
    }
}
