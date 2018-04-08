package DynamicProgramming;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        String s = "aacecaaa";

        System.out.println(shortestPalindrome(s));
    }

    private static String shortestPalindrome(String s) {
        // insights
        // add reverse of s to s and find longest common prefix/suffix of the whole string
        // remove the suffix from rev(s) and add the remaining to the beginning of s
        if(s == null || s.isEmpty()) return "";
        StringBuilder rev = new StringBuilder(s).reverse();
        // # is added to avoid the overlap in prefix/suffix search
        StringBuilder newString = new StringBuilder(s).append("#").append(rev);
        int longestCommonPS = findLongestPrefixSuffix(newString);
        String substring = rev.substring(0, rev.length() - longestCommonPS);
        return substring + s;

    }

    private static int findLongestPrefixSuffix(StringBuilder rev) {
        int[] temp = new int[rev.length()];

        temp[0] = 0;
        int i = 1;
        int j = 0;

        while(i != rev.length()){
            if(rev.charAt(i) == rev.charAt(j)){
                temp[i] = j+1;
                i++;
                j++;
            } else {
                if(j != 0){
                    j = temp[j-1];
                } else {
                    temp[i] = 0;
                    i++;
                }
            }
        }

        return temp[rev.length()-1];
    }
}
