package DynamicProgramming;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present
 * in both of them. A subsequence is a sequence that appears in the same relative order, but
 * not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are
 * subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.
 *
 *
 If last characters of both sequences match (or X[m-1] == Y[n-1]) then
 L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

 If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
 L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])
 */
public class LongestCommonSubsequence {

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs2( X, Y, m, n) );

    }

    private int lcs(char[] X, char[] Y, int m, int n) {
        if(m==0 || n==0) return 0;

        if(X[m-1] == Y[n-1]){
            return 1 + lcs(X, Y, m-1, n-1);
        } else {
            return max(lcs(X, Y, m-1, n), lcs(X, Y, m, n-1));
        }
    }

    // tabulated bottom up implementation
    int lcs2( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }

        int result = L[m][n];
        StringBuilder sb = new StringBuilder();

        //System.out.println(L[n][m]);
        while(m>0 && n>0){
            if(L[m][n] == L[m-1][n]){
                //move up cell
                m--;
            } else if(L[m][n] == L[m][n-1]){
                //move left cell
                n--;
            } else {
                sb.append(X[--m]);
                n--;
            }
        }
        System.out.println(sb.reverse().toString());

        return result;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
