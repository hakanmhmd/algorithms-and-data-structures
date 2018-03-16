package Strings;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same
 * number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class BinarySubstrings {
    public static void main(String[] args) {
        String binary = "001001110001";
        System.out.println(countBinarySubs(binary));
    }

    private static int countBinarySubs(String s) {
        int g = 0;
        int[] groups = new int[s.length()];
        groups[g] = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                g++;
                groups[g] = 1;
            } else {
                groups[g]++;
            }
        }

        int subs = 0;
        for(int i=1; i<=g; i++){
            subs += Math.min(groups[i], groups[i-1]);
        }
        return subs;
    }
}
