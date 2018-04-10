package DynamicProgramming;

/**
 * Longest palindrom subsequence (not substring)
 * Example: lpaspal -> lpspl (lps)
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "lpaspal";

        System.out.println(longestPalindromicSubseq(s, 0, s.length()-1));
        System.out.println(longestPalindromicSubseqBottomUp(s));
    }

    /**
     * recurrence relation: lpaspal
     *     first and last match - so 2 + lps(paspa)
     *  paspa
     *     if first and last dont match - max (lps(aspa), lps(pasp))
      */

    private static int longestPalindromicSubseq(String s, int left, int right) {
        if(left > right) return 0;
        if(left == right) return 1;
        if(s.charAt(left) == s.charAt(right)){
            return 2 + longestPalindromicSubseq(s, left+1, right-1);
        } else {
            return Math.max(longestPalindromicSubseq(s, left+1, right), longestPalindromicSubseq(s, left, right-1));
        }
    }

    private static int longestPalindromicSubseqBottomUp(String s){
        int n = s.length();
        int[][] p = new int[n][n];

        // len 1
        for(int i=0; i<n; i++){
            p[i][i] = 1;
        }

        for(int len=2; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j)){
                    p[i][j] = 2 + p[i+1][j-1];
                } else {
                    p[i][j] = Math.max(p[i+1][j], p[i][j-1]);
                }
            }
        }

        return p[0][n-1];
    }
}
