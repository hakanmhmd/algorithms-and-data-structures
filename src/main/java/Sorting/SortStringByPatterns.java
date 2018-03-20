package Sorting;

/**
 *Given two strings (of lowercase letters), a pattern and a string. The task is to sort string according
 * to the order defined by pattern. It may be assumed that pattern has all characters of the string
 * and all characters in pattern appear only once.
 */
public class SortStringByPatterns {
    public static void main(String[] args) {
        String pattern = "cyuogmlrdfphitxjakqvzbnes";
        String text = "wjcdokai";
        String s = sortByPattern(text, pattern);
        System.out.println(s);
    }

    private static String sortByPattern(String text, String pattern) {

        int[] count = new int[26];
        char[] tArr = text.toCharArray();
        char[] pArr = pattern.toCharArray();
        for(char c: tArr){
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c: pArr){
            while(count[c-'a']-- > 0){
                sb.append(c);
            }
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }
        }

        return sb.toString();
    }
}
