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
        String s = "aab";

        List<List<String>> res = partition(s);
        System.out.println(res);
    }

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
