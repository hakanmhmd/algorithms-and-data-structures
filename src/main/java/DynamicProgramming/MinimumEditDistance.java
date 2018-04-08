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
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
