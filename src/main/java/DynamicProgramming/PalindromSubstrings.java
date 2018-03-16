package DynamicProgramming;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different
 * substrings even they consist of same characters.
 */
public class PalindromSubstrings {
    public static void main(String[] args) {
        String s = "abaab";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstringsDP(s));
    }

    //Manachers algorithm for longest palindrome substring can also be used

    // expand around each center
    // there are 2n - 1 possible centers: either at letter or between two letters
    // O(n^2) time O(1) time
    private static int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            int left = i;
            int right = i;

            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                count++;
            }
            if(i != s.length()-1) {
                left = i;
                right = i + 1;

                while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                    count++;
                }

            }
        }

        return count;
    }

    // O(n^2) space and time
    private static int countSubstringsDP(String s){
        int n = s.length();
        int[][] dp = new int[n][n]; // stores the count of the palindromes
        boolean[][] isPalin = new boolean[n][n]; // true if i,j is palindrome

        //palindrome with len 1
        for(int i=0; i<n; i++){
            isPalin[i][i] = true;

        }

        //palindrome with len 2
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                isPalin[i][i+1] = true;
                dp[i][i+1] = 1;
            }
        }

        //palindrome with len > 2
        for(int gap=2; gap<n; gap++){
            for(int i=0; i<n-gap; i++){
                int j = i+gap;

                // if the pointers are same and the previous pointers are palindrome
                if(s.charAt(i) == s.charAt(j) && isPalin[i+1][j-1]){
                    isPalin[i][j] = true;
                }

                // Add current palindrome substring ( + 1)
                // and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
                // remove common palinrome substrings (- dp[i+1][j-1])
                if(isPalin[i][j]){
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
            }
        }

        return dp[0][n-1] + s.length();
    }




}
