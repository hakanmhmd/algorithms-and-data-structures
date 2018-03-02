package Sorting;

/**
 *Given two strings (of lowercase letters), a pattern and a string. The task is to sort string according
 * to the order defined by pattern. It may be assumed that pattern has all characters of the string
 * and all characters in pattern appear only once.
 */
public class SortStringByPatterns {
    public static void main(String[] args) {
        String pattern = "wcyuogmlrdfphitxjakqvzbnes";
        String text = "jcdokai";
        String s = sortByPattern(text, pattern);
        System.out.println(s);
    }

    private static String sortByPattern(String text, String pattern) {
        int[] letterCount = new int[26];
        for (int i = 0; i < text.length(); i++) {
            letterCount[text.charAt(i)-'a']++;
        }

        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            int count = letterCount[pattern.charAt(i)-'a'];
            for (int j = 0; j < count; j++) {
                sorted.append(pattern.charAt(i));
            }
        }

        return sorted.toString();
    }
}
