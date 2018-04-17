package Arrays;

/**
 * Reverse words in a string - inplace
 */
public class ReverseStringWords {
    public static void main(String[] args) {
        String s = "   The   man is playing football   ";
        System.out.println(s);
        reverseWords(s.trim().toCharArray());
        System.out.println(reverseWords(s));
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

    public static String reverseWords(String s) {
        if(s == null || s.trim().length() <= 1){
            return s.trim();
        }
        char[] strs = s.trim().toCharArray();
        reverse(strs, 0, strs.length - 1);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < strs.length){
            while (i < strs.length && strs[i] == ' '){
                i++;
            }
            if (i >= strs.length){
                break;
            }
            int j = i;
            while (j < strs.length && strs[j] != ' '){
                j++;
            }

            reverse(strs, i, j - 1);
            sb.append(strs, i, j - i).append(" ");
            i = j + 1;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
