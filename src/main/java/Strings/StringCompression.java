package Strings;

/**
 * Run length coding of a string - if the compression is longer than the original, return the original
 */
public class StringCompression {
    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddcc";

        System.out.println(compress(str));
    }

    private static String compress(String str) {
        // can precompute length in O(n) and return here if does not satifsy
        StringBuilder compressed = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
             count++;
             if(i+1 == str.length() || str.charAt(i) != str.charAt(i+1)){
                 compressed.append(str.charAt(i));
                 compressed.append(count);
                 count = 0;
             }
        }


        if(compressed.length() > str.length()){
            return str;
        }
        return compressed.toString();
    }
}
