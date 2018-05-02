package Backtracking;

import java.util.ArrayList;

/**
 * Given a set of words (without duplicates), find all word squares you can build from them.
 A sequence of words forms a valid word square if the kth row and column read the exact
 same string, where 0 ≤ k < max(numRows, numColumns).

 For example, the word sequence ["ball","area","lead","lady"] forms a word square because each
 word reads the same both horizontally and vertically.

 b a l l
 a r e a
 l e a d
 l a d y
 */
public class WordSquares {
    static class TrieNode {
        ArrayList<String> startsWith;
        TrieNode[] children;

        TrieNode(){
            children = new TrieNode[26];
            startsWith = new ArrayList<>();
        }
    }
    static class Trie {
        TrieNode root;

        Trie(String[] words){
            root = new TrieNode();
            for(String w: words){
                TrieNode curr = root;
                for(char ch: w.toCharArray()){
                    int i = ch - 'a';
                    if(curr.children[i] == null){
                        curr.children[i] = new TrieNode();
                    }
                    curr.startsWith.add(w);
                    curr = curr.children[i];
                }
            }
        }

        ArrayList<String> findByPrefix(String prefix){
            ArrayList<String> prefixWords = new ArrayList<>();
            TrieNode curr = root;
            for(char ch: prefix.toCharArray()){
                int i = ch - 'a';
                if(curr.children[i] == null) return prefixWords;
                curr = curr.children[i];
            }
            prefixWords.addAll(curr.startsWith);
            return prefixWords;
        }
    }

    public static void main(String[] args) {
        String[] words = {"abat","baba","atan","atal"};
        System.out.println(wordSquares(words));
    }

    private static ArrayList<ArrayList<String>> wordSquares(String[] words) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;

        Trie trie = new Trie(words);
        int len = words[0].length();
        ArrayList<String> squareBuilder = new ArrayList<>();
        for(String word : words){
            squareBuilder.add(word);
            search(trie, squareBuilder, len, res);
            squareBuilder.remove(squareBuilder.size()-1);
        }

        return res;
    }

    private static void search(Trie trie, ArrayList<String> squareBuilder, int len, ArrayList<ArrayList<String>> res) {
        if(squareBuilder.size() == len){
            res.add(new ArrayList<String>(squareBuilder));
            return;
        }

        // the index of the words added so far - used to form the prefix
        int colIndex = squareBuilder.size();
        StringBuilder prefix = new StringBuilder();
        for(String s : squareBuilder){
            prefix.append(s.charAt(colIndex));
        }

        ArrayList<String> byPrefix = trie.findByPrefix(prefix.toString());
        for(String p: byPrefix){
            squareBuilder.add(p);
            search(trie, squareBuilder, len, res);
            squareBuilder.remove(squareBuilder.size()-1);
        }
    }
}
