package Strings;

import java.util.*;

/**
 * Given a list of strings words representing an English Dictionary,
 * find the longest word in words that can be built one character at a
 * time by other words in words. If there is more than one possible answer,
 * return the longest word with the smallest lexicographical order.
 */
public class LongestWord {
    public static void main(String[] args) {
        String[] arr = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(arr));
        System.out.println(longestWord2(arr));
    }
    public static String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(String w: words) set.add(w);

        String longestWord = "";
        for(int i=0; i<words.length; i++){
            String word = words[i];

            if(word.length() > longestWord.length() ||
                    (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                boolean candidate = true;
                for (int j = 0; j < word.length() - 1; j++) {
                    String part = word.substring(0, j + 1);
                    if (!set.contains(part)) {
                        candidate = false;
                        break;
                    }
                }

                if(candidate){
                    longestWord = word;
                }
            }



        }

        return longestWord;

    }

    public static String longestWord2(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for (String word: words) {
            trie.insert(word, ++index); //indexed by 1
        }
        trie.words = words;
        return trie.dfs();
    }

    static class Node {
        char c;
        HashMap<Character, Node> children = new HashMap();
        int end;
        public Node(char c){
            this.c = c;
        }
    }

    static class Trie {
        Node root;
        String[] words;
        public Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c: word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() ||
                                word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei: node.children.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }

}
