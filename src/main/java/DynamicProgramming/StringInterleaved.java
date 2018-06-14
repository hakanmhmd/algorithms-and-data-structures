package DynamicProgramming;

/**
 * Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B.
 * C is said to be interleaving A and B, if it contains all characters of A and B and order of all
 * characters in individual strings is preserved.
 */
public class StringInterleaved {
    public static void main(String[] args) {
        String A = "XXY";
        String B = "XXZ";
        String C = "XXXXZY";

        System.out.println(isInterleaved(A,B,C));
        System.out.println(isInterleavedDP(A,B,C));
    }

    private static boolean isInterleaved(String a, String b, String c) {
        if(a.length() + b.length() != c.length()) return false;

        return isInterleaved(a,0,b,0,c,0);
    }

    private static boolean isInterleaved(String a, int i, String b, int j, String c, int k) {
        if(i==a.length() && j==b.length() && k == c.length()){
            return true;
        }

        if(k == c.length()) return false;

        return (a.charAt(i) == c.charAt(k) && isInterleaved(a,i+1,b,j,c,k+1)) ||
                (b.charAt(j) == c.charAt(k) && isInterleaved(a,i,b,j+1,c,k+1));

    }


    private static boolean isInterleavedDP(String a, String b, String c) {
        // Let us create a 2D table to store solutions of
        // subproblems.  dp[i][j] will be true if C[0..i+j-1]
        // is an interleaving of A[0..i-1] and B[0..j-1].
        boolean[][] dp = new boolean[a.length()+1][b.length()+1];
        if(a.length() + b.length() != c.length()) return false;

        for(int i=0; i<=a.length(); i++){
            for(int j=0; j<=b.length(); j++){
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0 && b.charAt(j-1) == c.charAt(i+j-1)){
                    dp[i][j] = dp[i][j-1];
                } else if(j == 0 && a.charAt(i-1) == c.charAt(i+j-1)){
                    dp[i][j] = dp[i-1][j];
                } else if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1)){
                    dp[i][j] = dp[i-1][j];
                } else if(a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)){
                    dp[i][j] = dp[i][j-1];
                } else if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}
