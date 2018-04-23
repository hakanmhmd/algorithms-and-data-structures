package Strings;

import java.util.*;

/**
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the
 * dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 *
 * i|nternationalizatio|n  --> i18n
 */
public class UniqueWordAbbreviation {
    static Map<String, String> abbrMap = new HashMap<>();
    public static void main(String[] args) {
        String[] list = {"deer", "door", "cake", "card", "a", "a"};

        Set<String> set = new HashSet<>();

        for (String s : list) {
            String abbr = getAbbr(s);
            if(abbrMap.containsKey(abbr)){
                if(!set.contains(s))
                    abbrMap.put(abbr, "");
            } else {
                abbrMap.put(abbr, s);
            }
            set.add(s);
        }

        System.out.println(isUnique("dear"));
        System.out.println(isUnique("cart"));
        System.out.println(isUnique("cane"));
        System.out.println(isUnique("make"));
        System.out.println(isUnique("a"));

        ///////////////////

        String s = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(validWordAbbreviation(s, abbr));

    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() < 2){
            return Objects.equals(word, abbr);
        }
        int i = 0;
        int j = 0;
        while(i < word.length() && j < abbr.length()){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
            } else if(Character.isDigit(abbr.charAt(j))){
                int k = j;
                while(Character.isDigit(abbr.charAt(j))){
                    j++;
                }
                int len = Integer.parseInt(abbr.substring(k, j));
                i += len;
            } else {
                return false;
            }
        }

        if(i == word.length() && j == abbr.length()) return true;
        return false;
    }

    private static boolean isUnique(String s) {
        String abbr = getAbbr(s);
        if(!abbrMap.containsKey(abbr) || abbrMap.get(abbr).equals(s)) return true;
        return false;
    }

    private static String getAbbr(String s){
        if(s.length() <= 2) return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.length()-2);
        sb.append(s.charAt(s.length()-1));

        return sb.toString();
    }
}
