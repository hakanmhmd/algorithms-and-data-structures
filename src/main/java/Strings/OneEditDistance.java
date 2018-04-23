package Strings;

/**
 * An edit between two strings is one of the following changes.

 Add a character
 Delete a character
 Change a character

 */
public class OneEditDistance {
    public static void main(String[] args) {
        String s1 = "banana";
        String s2 = "bbnaaa";

        System.out.println(isOneEditDistance(s1, s2));
    }

    private static boolean isOneEditDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(Math.abs(m-n) > 1) return false;

        int count = 0;
        int i=0, j=0;

        while(i<m && j<n){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            } else {
                if(count == 1) return false;

                if(m > n){
                    i++;
                } else if(n > m) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                count++;
            }
        }

        if(i<m || j<n) count++;

        return count<=1;
    }
}
