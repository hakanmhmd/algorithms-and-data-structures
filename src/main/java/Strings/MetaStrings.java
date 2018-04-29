package Strings;

/**
 * Given two strings, the task is to check whether these strings are meta strings or not. Meta strings are the
 * strings which can be made equal by exactly one swap in any of the strings. Equal string are not considered
 * here as Meta strings.
 */
public class MetaStrings {
    public static void main(String[] args) {
        String s1 = "rsting";
        String s2 = "string";

        System.out.println(isMeta(s1, s2));

        s1 = "java";
        s2 = "vaja";

        System.out.println(isMeta(s1, s2));
    }

    private static boolean isMeta(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int prev = -1, curr = -1; //indexes of unmatching chars
        int count = 0;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;

                if(count > 2) return false;

                prev = curr;
                curr = i;
            }
        }

        return count == 2 && s1.charAt(prev) == s2.charAt(curr) && s1.charAt(curr) == s2.charAt(prev);
    }
}
