package DynamicProgramming;

/**
 * Given a string s, find the longest palindromic substring in s.
 */
public class LongestPalindromSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;

        boolean[][] m = new boolean[s.length()][s.length()];
        int maxLen = 1;
        String longest = Character.toString(s.charAt(0));

        for(int k=0; k<s.length(); k++){
            for(int i=0; i<s.length()-k; i++){
                int j=i+k;
                if(s.charAt(i) == s.charAt(j) && (j-i<=2 || m[i+1][j-1])){
                    m[i][j] = true;

                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        longest = s.substring(i, j+1);
                    }
                }
            }
        }

        return longest;
    }
}
