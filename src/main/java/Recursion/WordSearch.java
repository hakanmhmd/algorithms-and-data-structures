package Recursion;

import java.util.Arrays;

/**
 * Created by hakanmehmed on 12/03/2018.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'c', 'a', 'a'},
                {'a', 'a', 'a'},
                {'b', 'c', 'd'}
        };
        String word = "aab";
        System.out.println(exist(board, word));

        System.out.println(exist2(board, word));
    }

    private static boolean exist2(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(word, board, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(String word, char[][] board, int i, int j, int current) {
        int m = board.length;
        int n = board[0].length;

        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }


        if(board[i][j] == word.charAt(current)){
            char temp = board[i][j];
            board[i][j] = '#';
            if(current == word.length()-1) return true;
            boolean res = dfs(word, board, i+1, j, current+1) ||
                    dfs(word, board, i-1, j, current+1) ||
                    dfs(word, board, i, j+1, current+1) ||
                    dfs(word, board, i, j-1, current+1);
            board[i][j] = temp;
            return res;
        }

        return false;
    }


    ///////////////////
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            Arrays.fill(visited[row], false);
        }
        char firstChar = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstChar) {
                    if (helper(word, 1, board, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean helper(String word, int current, char[][] board, int i, int j, boolean[][] visited) {
        if (current == word.length()) return true;
        boolean res = false;
        if (isValidPos(i + 1, j, board, visited) && board[i + 1][j] == word.charAt(current)) {
            visited[i][j] = true;
            res = helper(word, current + 1, board, i + 1, j, visited);
            visited[i][j] = false;
            if (res) return res;
        }
        if (isValidPos(i - 1, j, board, visited) && board[i - 1][j] == word.charAt(current)) {
            visited[i][j] = true;
            res = helper(word, current + 1, board, i - 1, j, visited);
            visited[i][j] = false;
            if (res) return res;
        }
        if (isValidPos(i, j - 1, board, visited) && board[i][j - 1] == word.charAt(current)) {
            visited[i][j] = true;
            res = helper(word, current + 1, board, i, j - 1, visited);
            visited[i][j] = false;
            if (res) return res;
        }
        if (isValidPos(i, j + 1, board, visited) && board[i][j + 1] == word.charAt(current)) {
            visited[i][j] = true;
            res = helper(word, current + 1, board, i, j + 1, visited);
            visited[i][j] = false;
            if (res) return res;
        }
        return res;
    }

    static boolean isValidPos(int i, int j, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
            return false;
        }
        if (!visited[i][j]) return true;
        return false;
    }
}
