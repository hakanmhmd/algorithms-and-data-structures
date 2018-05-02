package Strings;

import java.util.ArrayList;

/**
 * Write a function to generate the generalized abbreviations of a word.
 *
 * "ab" -> "1b", "a1", "2"
 */
public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        String s = "word";
        System.out.println(abbr("apple", 12));
        System.out.println(abbreviations(s));
    }

    // bit manipulation
    private static ArrayList<String> abbreviations(String s) {
        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i < (1 << s.length()); i++){
            String abbr = abbr(s, i);
            System.out.println(abbr);
            res.add(abbr);
        }
        return res;
    }

    private static String abbr(String s, int x) {
        StringBuilder sb = new StringBuilder();
        int oneCount = 0;
        for(int i=0; i<s.length(); i++, x >>= 1){
            if((x & 1) == 0) {
                if(oneCount != 0){
                    sb.append(oneCount);
                    oneCount = 0;
                }
                sb.append(s.charAt(i));
            } else {
                oneCount++;
            }
        }
        if(oneCount!=0)sb.append(oneCount);
        return sb.toString();
    }
}
