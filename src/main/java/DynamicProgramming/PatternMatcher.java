package DynamicProgramming;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 */
public class PatternMatcher {
    public static void main(String[] args) {
        String[][] inputToPattern = {
                {"aa", "a"},
                {"aa", "a*"},
                {"ab", ".*"},
                {"aab", "c*a*b"},
                {"mississippi", "mis*is*p*."}
        };

        process(inputToPattern);
    }

    private static void process(String[][] inputToPattern) {
        for(String[] in: inputToPattern){
            System.out.println(isMatch(in[0], in[1]) + ", " + isMatchDP(in[0], in[1]));
        }
    }

    // DP
    private static boolean isMatchDP(String text, String pattern) {
        boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];

        dp[0][0] = true;

        for(int i=1; i<dp[0].length; i++){
            dp[0][i] = pattern.charAt(i-1) == '*' && dp[0][i - 2];
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(text.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.'){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[text.length()][pattern.length()];
    }

    // Recursive
    private static boolean isMatch(String text, String pattern) {
        if(pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if(pattern.length() >= 2 && pattern.charAt(1) == '*'){
            // two possible branches
            return isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }



}
