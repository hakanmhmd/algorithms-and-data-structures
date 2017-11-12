package Arrays;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Check if two strings are permutation of each other
 */
public class CheckPermutation {
    public static void main(String[] args) {

        String[][] truePairs = {{"apple", "papel"}, {"carrot", "tarroc"}};
        String[][] falsePairs = {{"hello", "llloh"}, {"salmmon", "salmon"}};
        for (String[] pair : truePairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            assertTrue(checkPermutation(word1, word2));
        }

        for (String[] pair : falsePairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            assertFalse(checkPermutation(word1, word2));
        }
    }

    private static boolean checkPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int[] letter_map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int val = s1.charAt(i) - 'a';
            letter_map[val]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int val = s2.charAt(i) - 'a';
            letter_map[val]--;
            if(letter_map[val] < 0) return false;
        }

        return true;
    }
}
