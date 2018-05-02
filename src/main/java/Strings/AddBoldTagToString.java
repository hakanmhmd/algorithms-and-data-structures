package Strings;

/**
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap
 * the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them
 * together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are
 * consecutive, you need to combine them.
 */
public class AddBoldTagToString {
    public static void main(String[] args) {
        String s = "aaabbcc";
        String[] dict = {"aaa","aab","bc"};

        System.out.println(addBoldTag(s, dict));
    }

    // One method is similar to interval merging

    // boolean marking array
    private static String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(String d: dict){
            for(int i=0; i<=s.length()-d.length(); i++){
                if(s.substring(i, i+d.length()).equals(d)){
                    for(int j=i; j<i+d.length(); j++){
                        bold[j]=true;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length();){
            if(bold[i]){
                res.append("<b>");
                while(i<s.length() && bold[i]){
                    res.append(s.charAt(i));
                    i++;
                }
                res.append("</b>");
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }

        return res.toString();
    }
}
