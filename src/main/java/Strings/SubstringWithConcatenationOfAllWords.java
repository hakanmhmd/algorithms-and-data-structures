package Strings;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters.
 *
 * For example, given: s="barfoothefoobarman" & words=["foo", "bar"], return [0,9].
 */
public class SubstringWithConcatenationOfAllWords {
    // This problem is similar (almost the same) to Longest Substring Which Contains 2 Unique Characters.
    // Since each word in the dictionary has the same length, each of them can be treated as a single character.
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] dict = {"foo", "bar"};

        System.out.println(findSubstring(s, dict));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return result;
        }

        int wordLen = words[0].length();
        int numWord = words.length;
        int sLen = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int j=0; j<wordLen; j++){
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;//start index of start
            int count = 0;//count totoal qualified words so far

            for(int i=j; i<=sLen-wordLen; i=i+wordLen){
                String sub = s.substring(i, i+wordLen);
                if(map.containsKey(sub)){
                    //set frequency in current map
                    if(currentMap.containsKey(sub)){
                        currentMap.put(sub, currentMap.get(sub)+1);
                    }else{
                        currentMap.put(sub, 1);
                    }

                    count++;

                    while(currentMap.get(sub)>map.get(sub)){
                        String left = s.substring(start, start+wordLen);
                        currentMap.put(left, currentMap.get(left)-1);

                        count--;
                        start = start + wordLen;
                    }


                    if(count==numWord){
                        result.add(start); //add to result

                        //shift right and reset currentMap, count & start point
                        String left = s.substring(start, start+wordLen);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + wordLen;
                    }
                }else{
                    currentMap.clear();
                    start = i+wordLen;
                    count = 0;
                }
            }
        }

        return result;
    }
}
