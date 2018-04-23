package Strings;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string of unique characters .
 *
 * P(a1) = [a1]
 * P(a2) = P(a1) + a2 inserted into all possible locations = [a1a2, a2a1]
 * P(a3) = P(a2) + a3 = [a1a2a3, a1a3a2, a3a1a2, a2a1a3, a2a3a1, a3a2a1]
 *
 **/

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abs";
        ArrayList<String> perms = findPerms(str);

        for (int i = 0; i < perms.size(); i++) {
            System.out.println(perms.get(i));
        }

        System.out.println();
        permute(str, 0, str.length()-1);
    }

    private static ArrayList<String> findPerms(String str) {
        if(str == null) return null;

        ArrayList<String> perms = new ArrayList<>();
        //base case
        if(str.length() <= 1){
            perms.add(str);
            return perms;
        }

        char first = str.charAt(0);
        String rem = str.substring(1);
        ArrayList<String> words = findPerms(rem);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharAt(word, first, i);
                perms.add(s);
            }
        }
        return perms;
    }

    private static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    private static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
