package DynamicProgramming;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by hakanmehmed on 19/03/2018.
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "lclc", y = "clcl";

        System.out.println(longestCommonSubstring(x.toCharArray(), y.toCharArray(), x.length(), y.length()));
        System.out.println(LCS(x, y));
    }

    private static int longestCommonSubstring(char[] x, char[] y, int m, int n) {
        if(m==0 || n==0){
            return 0;
        }
        if(x[m-1] == y[n-1]){
            return 1 + longestCommonSubstring(x, y, m-1, n-1);
        }
        return Math.max(longestCommonSubstring(x, y, m, n-1), longestCommonSubstring(x, y, m-1, n));
    }

    private static List<String> LCS(String x, String y){
        int xLen = x.length();
        int yLen = y.length();
        List<String> res = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;
        int[][] dp = new int[xLen][yLen];

        for(int i=0; i<xLen; i++){
            for(int j=0; j<yLen; j++){
                if(x.charAt(i) == y.charAt(j)){
                    if(i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = 1 + dp[i-1][j-1];

                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        res = new ArrayList<>();
                        res.add(x.substring(i-maxLen+1, i+1));
                    } else if(dp[i][j] == maxLen){
                        res.add(x.substring(i-maxLen+1, i+1));
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return res;
    }
}
