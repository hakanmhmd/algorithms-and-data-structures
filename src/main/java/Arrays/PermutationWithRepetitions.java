package Arrays;

import java.util.ArrayList;

/**
 * Permutation of a string with duplication
 */
public class PermutationWithRepetitions {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(perms("", s, new ArrayList<>()));
    }

    private static ArrayList<String> perms(String prefix, String s, ArrayList<String> list) {
        if(prefix.length() == s.length()){
            list.add(prefix);
            return list;
        }

        for(int i=0; i<s.length(); i++){
            perms(prefix + s.charAt(i), s, list);
        }

        return list;
    }

}
