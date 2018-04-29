package Trie;

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has
 * one character. Find all possible words that can be formed by a sequence of adjacent characters.
 * Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell.
 */
public class Boggle {
    static final int SIZE = 26;

    static final int M = 3;
    static final int N = 3;

    static class TrieNode
    {
        TrieNode[] children = new TrieNode[SIZE];

        // isLeaf is true if the node represents
        // end of a word
        boolean isLeaf;

        //constructor
        public TrieNode() {
            isLeaf = false;
            for (int i =0 ; i< SIZE ; i++)
                children[i] = null;
        }
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just
    // marks isLeaf node
    static void insert(TrieNode root, String Key) {
        int n = Key.length();
        TrieNode pChild = root;

        for (int i=0; i<n; i++)
        {
            int index = Key.charAt(i) - 'A';

            if (pChild.children[index] == null)
                pChild.children[index] = new TrieNode();

            pChild = pChild.children[index];
        }

        // make last node as isLeaf node
        pChild.isLeaf = true;
    }

    // function to check that current location
    // (i and j) is in matrix range
    static boolean isSafe(int i, int j, boolean visited[][]) {
        return (i >=0 && i < M && j >=0 &&
                j < N && !visited[i][j]);
    }

    // A recursive function to print all words present on boggle
    static void searchWord(TrieNode root, char boggle[][], int i,
                           int j, boolean visited[][], String str) {
        // if we found word in trie / dictionary
        if (root.isLeaf)
            System.out.println(str);

        // If both I and j in  range and we visited
        // that element of matrix first time
        if (isSafe(i, j, visited))
        {
            // make it visited
            visited[i][j] = true;

            // traverse all child of current root
            for (int K =0; K < SIZE; K++)
            {
                if (root.children[K] != null)
                {
                    // current character
                    char ch = (char) (K + 'A') ;

                    // Recursively search reaming character of word
                    // in trie for all 8 adjacent cells of boggle[i][j]
                    if (isSafe(i+1,j+1,visited) && boggle[i+1][j+1] == ch)
                        searchWord(root.children[K],boggle,i+1,j+1, visited,str+ch);
                    if (isSafe(i, j+1,visited)  && boggle[i][j+1] == ch)
                        searchWord(root.children[K],boggle,i, j+1, visited,str+ch);
                    if (isSafe(i-1,j+1,visited) && boggle[i-1][j+1] == ch)
                        searchWord(root.children[K],boggle,i-1, j+1, visited,str+ch);
                    if (isSafe(i+1,j, visited)  && boggle[i+1][j] == ch)
                        searchWord(root.children[K],boggle,i+1, j, visited,str+ch);
                    if (isSafe(i+1,j-1,visited) && boggle[i+1][j-1] == ch)
                        searchWord(root.children[K],boggle,i+1, j-1, visited,str+ch);
                    if (isSafe(i, j-1,visited)&& boggle[i][j-1] == ch)
                        searchWord(root.children[K],boggle,i,j-1, visited,str+ch);
                    if (isSafe(i-1,j-1,visited) && boggle[i-1][j-1] == ch)
                        searchWord(root.children[K],boggle,i-1, j-1, visited,str+ch);
                    if (isSafe(i-1, j,visited) && boggle[i-1][j] == ch)
                        searchWord(root.children[K],boggle,i-1, j, visited,str+ch);
                }
            }

            // make current element unvisited
            visited[i][j] = false;
        }
    }

    // Prints all words present in dictionary.
    static void findWords(char boggle[][], TrieNode root)
    {
        // Mark all characters as not visited
        boolean[][] visited = new boolean[M][N];
        TrieNode pChild = root ;

        String str = "";

        // traverse all matrix elements
        for (int i = 0 ; i < M; i++)
        {
            for (int j = 0 ; j < N ; j++)
            {
                // we start searching for word in dictionary
                // if we found a character which is child
                // of Trie root
                if (pChild.children[(boggle[i][j]) - 'A'] != null)
                {
                    str = str+boggle[i][j];
                    searchWord(pChild.children[(boggle[i][j]) - 'A'],
                            boggle, i, j, visited, str);
                    str = "";
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        // Let the given dictionary be following
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};

        // root Node of trie
        TrieNode root = new TrieNode();

        // insert all words of dictionary into trie
        int n = dictionary.length;
        for (int i=0; i<n; i++)
            insert(root, dictionary[i]);

        char boggle[][] = {
                {'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}
        };

        findWords(boggle, root);

    }
}
