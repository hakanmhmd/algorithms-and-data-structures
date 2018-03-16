package DynamicProgramming;

/**
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 */
public class MinASCIIDeleteSum {
    public static void main(String[] args) {
        String s1 = "delete", s2 = "leet";
        System.out.println(minDeleteSum(s1, s2));
    }

    private static int minDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=s1.length()-1; i>=0; i--){
            dp[i][s2.length()] = dp[i+1][s2.length()] + s1.codePointAt(i);
        }

        for(int i=s2.length()-1; i>=0; i--){
            dp[s1.length()][i] = dp[s1.length()][i+1] + s2.codePointAt(i);
        }

        for (int i = s1.length()-1; i >= 0; i--) {
            for(int j=s2.length()-1; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    // we can ignore them
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    //we will have to delete at least one of them
                    dp[i][j] = Math.min(dp[i+1][j] + s1.codePointAt(i), dp[i][j+1] + s2.codePointAt(j));
                }
            }
        }

        return dp[0][0];
    }
}
