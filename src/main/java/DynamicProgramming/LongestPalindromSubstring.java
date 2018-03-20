package DynamicProgramming;

/**
 * Given a string s, find the longest palindromic substring in s.
 */
public class LongestPalindromSubstring {
    public static void main(String[] args) {
        String s = "banana";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
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

    static String longestPalindrome2(String s){
        int n = s.length();
        int maxLen = 1;
        int start = 0;

        boolean[][] p = new boolean[n][n];

        //one letter palindroms
        for(int i=0; i<n; i++){
            p[i][i] = true;
        }

        //two letter palindromes
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                p[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // three or more letter palindromes
        for(int len=3; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) // first and last should match
                        && p[i+1][j-1]){ // the substring in between should be palindrome
                    p[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, maxLen + 1);
    }
}
