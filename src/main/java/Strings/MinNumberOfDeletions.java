package Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a dictionary and a word, find the minimum number of deletions needed on the word in order to make it a valid word.
 */
public class MinNumberOfDeletions {
    private static final Set<String> DICTIONARY = new HashSet<>();

    public MinNumberOfDeletions() {
        DICTIONARY.add("abc");
        DICTIONARY.add("abd");
        DICTIONARY.add("a");
        DICTIONARY.add("ab");
        DICTIONARY.add("acd");
        DICTIONARY.add("abcde");
    }


    private int getMinDeletions(String givenWord) {
        if(DICTIONARY.contains(givenWord)) return 0;
        int min = Integer.MAX_VALUE;
        String str = "";
        for (int level = 0; level < (int) Math.pow(2, givenWord.length()) - 1; level++) {
            String reducedStr = getReducedStr(givenWord, level);
            if (DICTIONARY.contains(reducedStr)) {
                int diffLength = givenWord.length() - reducedStr.length();
                if (min > diffLength) {
                    str = reducedStr;
                    min = diffLength;
                }
            }
        }
        System.out.println(str);
        return min;
    }

    private String getReducedStr(String givenWord, int level) {
        char[] givenArr = givenWord.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = givenArr.length-1;
        while(level != 0){
            if((level & 1) == 1){
                sb.insert(0, givenArr[i]);
            }
            i--;
            level >>>= 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MinNumberOfDeletions makeValidWord = new MinNumberOfDeletions();
        System.out.println(makeValidWord.getMinDeletions("aqwtbscde"));
    }
}
