package Strings;

/**
 * Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’
 * with at-most one ‘b’ and two ‘c’s allowed.
 */
public class StringWithABC {
    public static void main(String[] args) {
        int n = 4;
        int[][][] dp = new int[n+1][2][3];
        System.out.println(countStrings(n, 1, 2, dp));
    }

    private static int countStrings(int n, int bCount, int cCount, int[][][] dp) {
        if(n == 0) return 1;
        if(dp[n][bCount][cCount] != 0) return dp[n][bCount][cCount];

        int res = 0;
        res += countStrings(n-1, bCount, cCount, dp);
        if(bCount > 0) res += countStrings(n-1, bCount-1, cCount, dp);
        if(cCount > 0) res += countStrings(n-1, bCount, cCount-1, dp);

        dp[n][bCount][cCount] = res;

        return res;
    }

    // O(1)
    static int countStr(int n) {
        return 1+(n*2)+(n*((n*n)-1)/2);
    }
}
