package Arrays;

import java.util.ArrayList;

/**
 * Print a matrix diagonally starting from top left corner
 */
public class PrintMatrixDiagonally {
    public static void main(String[] args) {
        int[][] m = {
                {1 ,2 ,3 ,4 ,5},
                {6 ,7 ,8 ,9 ,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };

        ArrayList<ArrayList<Integer>> diag = printDiagonally(m);
        System.out.println(diag);
    }

    private static ArrayList<ArrayList<Integer>> printDiagonally(int[][] m) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int rows = m.length;
        int cols = m[0].length;

        for(int i=0; i<rows; i++){
            int col = 0;
            int row = i;
            ArrayList<Integer> list = new ArrayList<>();
            while(row >= 0 && col < cols){
                list.add(m[row][col]);
                row--;
                col++;
            }
            res.add(list);
        }

        for(int i=1; i<cols; i++){
            int row = rows-1;
            int col = i;
            ArrayList<Integer> list = new ArrayList<>();
            while(row>=0 && col < cols){
                list.add(m[row][col]);
                row--;
                col++;
            }
            res.add(list);
        }

        return res;
    }
}
