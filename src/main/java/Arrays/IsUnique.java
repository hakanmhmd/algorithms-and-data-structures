package Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Check if each character in a string is unique
 */
public class IsUnique {
    public static void main(String[] args) {
        String[] testP = {"abcde", "kite", "padle"};
        String[] testF = {"hello", "apple"};

        for (String s : testP) {
            assertTrue(isUniqueChars(s));
            assertTrue(isUniqueChars2(s));
        }

        for (String s : testF) {
            assertFalse(isUniqueChars(s));
            assertFalse(isUniqueChars2(s));
        }

    }



    // Use of letter map
    private static boolean isUniqueChars(String s) {
        // ascii - 128 chars
        if(s.length() > 128) return false;

        boolean[] charset = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if(charset[val]) {
                return false;
            }
            charset[val] = true;
        }

        return true;
    }

    // Without any additional data structure
    private static boolean isUniqueChars2(String s) {
        if(s.length() > 26) return false;

        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
             int val = s.charAt(i) - 'a';

            if ((checker & (1 << val)) > 0) return false;
            checker = checker | 1 << val;
        }

        return true;

    }
}
