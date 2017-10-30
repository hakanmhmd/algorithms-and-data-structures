package Graph;

import com.apple.eawt.AppEvent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence
 * from start to end, such that only one letter can be changed at a time and
 * each intermediate word must exist in the dictionary.
 */
public class WordLadder {
    private static class WordNode {
        String word;
        int numSteps;

        public WordNode(String word, int numSteps){
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> set = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        int l =ladderLength(start, end, set);
        System.out.println(l);
    }

    private static int ladderLength(String start, String end, Set<String> set) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1));

        set.add(end);

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            if(word.equals(end)) return top.numSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    arr[i] = c;

                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        set.remove(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }

        return 0;
    }

}
