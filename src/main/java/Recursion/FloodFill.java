package Recursion;

import java.util.Arrays;

/**
 * Given a matrix where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’.
 * A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if there are ‘X’ at locations
 * just below, just above, just left and just right of it.
 */
public class FloodFill {
    public static void main(String[] args) {
        char mat[][] =  {
                {'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'},
        };

        fill(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    // replace all O with -
    // traverse 4 edges and flood fill - to O
    private static void fill(char[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0) return;

        for (int i=0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 'O')
                    mat[i][j] = '-';
            }
        }

        for(int i=0; i<mat.length; i++){
            if(mat[i][0] == '-') floodFillUtil(mat, i, 0, '-', 'O');
            if(mat[i][mat[i].length-1] == '-') floodFillUtil(mat, i, mat[i].length-1, '-', 'O');
        }

        for(int j=0; j<mat[0].length; j++){
            if(mat[0][j] == '-') floodFillUtil(mat, 0, j, '-', 'O');
            if(mat[mat.length-1][j] == '-') floodFillUtil(mat, mat.length-1, j, '-', 'O');
        }

        for (int i=0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == '-')
                    mat[i][j] = 'X';
            }
        }

    }

    private static void floodFillUtil(char[][] mat, int i, int j, char prev, char curr) {
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[i].length || mat[i][j] != prev){
            return;
        }

        mat[i][j] = curr;
        floodFillUtil(mat, i+1, j, prev, curr);
        floodFillUtil(mat, i-1, j, prev, curr);
        floodFillUtil(mat, i, j+1, prev, curr);
        floodFillUtil(mat, i, j-1, prev, curr);
    }
}
