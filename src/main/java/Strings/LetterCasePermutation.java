package Strings;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by hakanmehmed on 14/03/2018.
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b234";
        System.out.println(letterCasePermutation(s));
    }
    public static List<String> letterCasePermutation(String S) {
        List<StringBuilder> result = new ArrayList<>();

        result.add(new StringBuilder());

        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            List<StringBuilder> temp = new ArrayList<>();
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                // letter
                for(int j=0; j<result.size(); j++){
                    StringBuilder sb = result.get(j);
                    temp.add(new StringBuilder(sb).append(Character.toUpperCase(ch)));
                    temp.add(new StringBuilder(sb).append(Character.toLowerCase(ch)));
                }
            } else {
                for(int j=0; j<result.size(); j++){
                    StringBuilder sb = result.get(j);
                    temp.add(new StringBuilder(sb).append(ch));
                }
            }

            result = temp;
        }

        List<String> finalResult = new ArrayList<>();
        for (StringBuilder sb: result)
            finalResult.add(sb.toString());
        return finalResult;
    }
}
