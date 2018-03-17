package Arrays;

import java.util.Arrays;

/**
 *Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {1,0,0,1,0,1,1},
                {0,1,0,1,1,0,0},
                {1,0,1,1,0,0,1},
                {1,0,0,0,1,0,0}
        };

        gameOfLife(board);

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int lives = getLiveNeighbours(i, j, board);
                if(board[i][j] == 1){
                    if (lives == 2 || lives == 3){
                        board[i][j] = 1; // live remains live
                    } else {
                        board[i][j] = 2; // live goes dead
                    }
                } else {
                    if(lives == 3){
                        board[i][j] = 3; // dead goes live
                    } else {
                        board[i][j] = 0; //dead stays dead
                    }
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 1 || board[i][j] == 3){
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0; //dead stays dead
                }
            }
        }


    }

    static int getLiveNeighbours(int i, int j, int[][] board){
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, board.length - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, board[0].length - 1); y++) {
                if(x == i && y == j) continue;
                if(board[x][y] == 1 || board[x][y] == 2) lives++;
            }
        }
        //System.out.println(lives);
        return lives;

    }
}
