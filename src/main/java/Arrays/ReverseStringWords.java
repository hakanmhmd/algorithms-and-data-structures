package Arrays;

import java.util.Arrays;

/**
 * Reverse words in a string - inplace
 */
public class ReverseStringWords {
    public static void main(String[] args) {
        String s = "The man is playing football";
        System.out.println(s);
        reverseWords(s.toCharArray());
    }

    private static void reverseWords(char[] s) {
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] == ' '){
                reverse(s, j, i-1);
                j = i+1;
            }
        }
        reverse(s, j, s.length-1); // reverse the last word
        reverse(s, 0, s.length-1); // reverse all text
        System.out.println(new String(s));
    }

    private static void reverse(char[] s, int j, int i) {
        while(j < i){
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j++;
            i--;
        }
    }
}
