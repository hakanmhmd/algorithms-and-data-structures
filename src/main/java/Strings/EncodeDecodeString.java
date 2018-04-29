package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent
 * over the network and is decoded back to the original list of strings.
 */
public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("str", "s", "", "java", null, "");

        String encoded = encode(strs);
        System.out.println(encoded);
        List<String> decoded = decode(encoded);
        System.out.println(decoded);
    }

    private static List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }

        int i = 0;
        while (i < s.length()) {
            int len = 0;
            // Get length
            while (i < s.length() && s.charAt(i) != '#') {
                len = len * 10 + Character.getNumericValue(s.charAt(i));
                i++;
            }

            String str = s.substring(i + 1, i + len + 1);
            result.add(str);
            i = i + len + 1;
        }

        return result;
    }

    private static String encode(List<String> strs) {
        if(strs == null || strs.size() == 0) return "";

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            if (str == null || str.length() == 0) {
                sb.append("0#");
            } else {
                sb.append(str.length() + "#" + str);
            }
        }

        return sb.toString();
    }
}
