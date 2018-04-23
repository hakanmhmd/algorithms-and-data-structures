package DynamicProgramming;

/**
 * How many edit are needed to convert one string to another - operations are insertion, substitution, deletion
 * Uses: spell correction, biology (sequences of nucleotides), ml, speech recognition
 */
public class MinimumEditDistance {
    public static void main(String[] args) {
        String s1 = "kitten";
        String s2 = "sitting";

        System.out.println(minEditDistance(s1, s2));

        System.out.println(minEditDistance2(s1, s2, s1.length(), s2.length()));
    }

    private static int minEditDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++){
            dp[i][0] = i;
        }

        for(int i=1; i<=s2.length(); i++){
            dp[0][i] = i;
        }



        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], //insert
                                                     dp[i-1][j]), // remove
                                                     dp[i-1][j-1]); //replace
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    // Exponential complexity O(3^m)
    private static int minEditDistance2(String s1, String s2, int m, int n){
        if(m == 0) return n;
        if(n == 0) return m;

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return minEditDistance2(s1, s2, m-1, n-1);
        }

        return 1 + Math.min(minEditDistance2(s1, s2, m, n-1), // insert
                  Math.min(minEditDistance2(s1, s2, m-1, n), //remove
                           minEditDistance2(s1, s2, m-1, n-1))); //replace
    }
}
