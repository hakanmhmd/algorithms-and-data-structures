package Trie;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Trie data structure
 * Used for efficient information retrieval O(m) where is m is the string length
 */
public class Trie {
    static TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    static void insert(String key){
        TrieNode current = root;
        for(int i=0; i<key.length(); i++){
            int ch = key.charAt(i) - 'a';
            if(current.children[ch] == null){
                current.children[ch] = new TrieNode();
            }
            current.prefixes.add(key);
            current = current.children[ch];
        }
        current.prefixes.add(key);
        current.isEnd = true;
    }

    static boolean search(String key){
        TrieNode current = root;
        for(int i=0; i<key.length(); i++){
            int ch = key.charAt(i) - 'a';
            if(current.children[ch] == null) return false;
            current = current.children[ch];
        }
        return (current != null && current.isEnd);
    }

    static ArrayList<String> wordsWithPrefix(String prefix){
        TrieNode current = root;
        for(int i=0; i<prefix.length(); i++){
            int ch = prefix.charAt(i) - 'a';
            if(current.children[ch] == null){
                return new ArrayList<>();
            }
            current = current.children[ch];
        }
        if(current == null) {
            return new ArrayList<>();
        }
        return current.prefixes;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "hack", "hackerrank"};

        for (int i = 0; i < keys.length ; i++) {
            insert(keys[i]);
        }

        System.out.println(search("the"));
        System.out.println(search("that"));
        System.out.println(search("answe"));
        System.out.println(wordsWithPrefix("hac"));
        System.out.println(wordsWithPrefix("hak"));
    }
}
