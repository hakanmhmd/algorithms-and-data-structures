package Backtracking;

import java.util.ArrayList;


/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class NQueen {
    static class Position {
        int row, col;
        Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "[" + row + ", " + col + "]";
        }
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<Position> queens = new ArrayList<>();

        if(hasSolution(n, 0, queens)){
            System.out.println(queens);
        } else {
            System.out.println("No solution");
        }
    }

    private static boolean hasSolution(int n, int currentRow, ArrayList<Position> queens) {
        if(currentRow == n) return true;
        int col = 0;

        while(col < n){
            if(!queenUnderAttack(currentRow, col,queens)){
                queens.add(new Position(currentRow, col));
                if(hasSolution(n, currentRow+1, queens)) {
                    return true;
                } else {
                    queens.remove(queens.size()-1);
                }
            }
            col++;
        }

        return false;
    }

    private static boolean queenUnderAttack(int currentRow, int col, ArrayList<Position> queens) {
        for (int i = 0; i < queens.size(); i++) {
            Position queen = queens.get(i);
            if(queen.row == currentRow || queen.col == col) return true;
            if(Math.abs(queen.row - currentRow) == Math.abs(queen.col - col)) return true;
        }

        return false;
    }


}
