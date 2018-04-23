package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 Return all possible palindrome partitioning of s.
 For example, given s = "aab", Return
 [ ["aa","b"], ["a","a","b"] ]
 */
public class PalindromePartition {
    public static void main(String[] args) {
        String s = "banana";

        List<List<String>> res = partition(s);
        System.out.println(res);

        System.out.println("Minumum cuts: " + palindromPartition(s));
    }

    private static int palindromPartition(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];

        for(int i=0; i<s.length(); i++){
            dp[i][i] = true; //single letter words
        }

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
            }
        }

        for(int len=3; len<=s.length(); len++){
            for(int i=0; i<s.length()-len+1; i++){
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
            }
        }

        int[] cuts = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            int temp = Integer.MAX_VALUE;
            if(dp[0][i]){ // whole palindrome
                cuts[i] = 0;
            } else {
                for(int j=0; j<i; j++){
                    if(dp[j+1][i] && temp > cuts[j] + 1){
                        temp = cuts[j] + 1;
                    }
                }
                cuts[i] = temp;
            }
        }

        return cuts[s.length()-1];
    }

    /////////////////////////////////

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private static void helper(List<List<String>> res, ArrayList<String> list, String s, int pos) {
        if(pos >= s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=pos+1; i<=s.length(); i++){
            String subs = s.substring(pos, i);
            if(!isPalindrome(subs)){
                continue;
            }
            list.add(subs);
            helper(res, list, s, i);
            list.remove(list.size()-1);
        }
    }

    private static boolean isPalindrome(String subs) {
        int left = 0;
        int right = subs.length()-1;

        while(left < right){
            if(subs.charAt(left) != subs.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
