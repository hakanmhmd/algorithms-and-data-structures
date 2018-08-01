package Trie;

import java.util.ArrayList;

/**
 * Node of a trie
 */
public class TrieNode {
    static final int ALPHABET_SIZE = 26;
    public TrieNode[] children;
    public boolean isEnd;
    public ArrayList<String> prefixes;


    public TrieNode(){
        prefixes = new ArrayList<>();
        isEnd = false;
        children = new TrieNode[ALPHABET_SIZE];
        for(int i=0; i<ALPHABET_SIZE; i++){
            children[i] = null;
        }
    }
}
