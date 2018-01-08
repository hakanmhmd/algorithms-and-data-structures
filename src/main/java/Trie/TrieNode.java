package Trie;

/**
 * Node of a trie
 */
public class TrieNode {
    static final int ALPHABET_SIZE = 26;
    public TrieNode[] children;
    public boolean isEnd;
    public int prefixes;

    public TrieNode(){
        prefixes = 0;
        isEnd = false;
        children = new TrieNode[ALPHABET_SIZE];
        for(int i=0; i<ALPHABET_SIZE; i++){
            children[i] = null;
        }
    }
}
