package Graph;

import java.util.*;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word
 * pairs pairs, determine if two sentences are similar.

 For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar,
 if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 */
public class SentenceSimilarity {
    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        String[][] pairs = {
                {"great", "good"},
                {"fine", "good"},
                {"acting","drama"},
                {"skills","talent"}
        };

        System.out.println(areSimilar(words1, words2, pairs));
    }

    private static boolean areSimilar(String[] words1, String[] words2, String[][] pairs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        if(words1.length != words2.length) return false;

        for(String[] pair: pairs){
            for(String p : pair){
                if(!map.containsKey(p)){
                    map.put(p, new ArrayList<String>());
                }
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        for(int i=0; i<words1.length; i++){
            String w1 = words1[i];
            String w2 = words2[i];

            if(!dfs(w1, w2, map)){
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(String w1, String w2, HashMap<String, ArrayList<String>> map) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.add(w1);

        while(!stack.isEmpty()){
            String temp = stack.pop();
            visited.add(temp);
            if(temp.equals(w2)) return true;
            if(map.containsKey(temp)){
                ArrayList<String> neighbours = map.get(temp);
                for(String n : neighbours){
                    if(!visited.contains(n)){
                        stack.push(n);
                    }
                }
            }
        }
        return false;
    }
}
