package DynamicProgramming;

/**
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 */
public class MinInsertionsPalindrome {
    public static void main(String[] args) {
        String s = "geeks";
        System.out.println(minInsertions(s, 0 ,s.length()-1));
        System.out.println(minInsertions(s));
    }

    private static int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];

        // strings of len 1 = 0 - trivially satisfied

        // len 2
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 0;
            } else {
                dp[i][i+1] = 1;
            }
        }

        //len 3 or more
        for(int gap=3; gap<=s.length(); gap++){
            for(int i=0; i<s.length()-gap+1; i++){
                int j = i+gap-1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        return dp[0][s.length()-1];
    }

    private static int minInsertions(String s, int start, int end) {
        if(start > end){
            return Integer.MAX_VALUE;
        }
        if(start == end){
            return 0;
        }
        if(start == end-1) return s.charAt(start) == s.charAt(end) ? 0 : 1;

        return s.charAt(start) == s.charAt(end)
                ? minInsertions(s, start+1, end-1)
                : Math.min(minInsertions(s, start+1, end), minInsertions(s, start, end-1)) + 1;

    }


}
