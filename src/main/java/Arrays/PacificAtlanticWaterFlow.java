package Arrays;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell
 * in a continent, the "Pacific ocean" touches the left and top edges of the matrix and
 * the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to
 * another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 *   Pacific ~   ~   ~   ~   ~
     ~  1   2   2   3  (5) *
     ~  3   2   3  (4) (4) *
     ~  2   4  (5)  3   1  *
     ~ (6) (7)  1   4   5  *
     ~ (5)  1   1   2   4  *
     *   *   *   *   * Atlantic
 */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<int[]> ints = pacificAtlantic(m);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();
        if(matrix.length == 0 || matrix[0].length == 0) return result;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];  // the pacific boolean table
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length]; // the atlantic booean table
        //initially, all the top and left cells are flooded with pacific water
        //and all the right and bottom cells are flooded with atlantic water
        for(int i = 0; i < matrix.length; i++){
            pacific[i][0] = true;
            atlantic[i][matrix[0].length-1] = true;
        }
        for(int i = 0; i < matrix[0].length; i++){
            pacific[0][i] = true;
            atlantic[matrix.length-1][i] = true;
        }
        //we go around the matrix and try to flood the matrix from 4 side.
        for(int i = 0; i < matrix.length; i++){
            boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
            boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
            water(pacific, pacificVisited, matrix, i,0);
            water(atlantic, atlanticVisited, matrix, i, matrix[0].length - 1);
        }
        for(int i = 0; i < matrix[0].length; i++){
            boolean[][] pacificVisited = new boolean[matrix.length][matrix[0].length];
            boolean[][] atlanticVisited = new boolean[matrix.length][matrix[0].length];
            water(pacific, pacificVisited, matrix, 0,i);
            water(atlantic, atlanticVisited, matrix, matrix.length - 1, i);
        }
        //check the shared points among 2 tables
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    int[] element = {i,j};
                    result.add(element);
                }
            }
        }
        return result;
    }

    private static void water(boolean[][] wet, boolean[][] visited, int[][] matrix, int i, int j) {
        wet[i][j] = true;
        visited[i][j] = true;

        if(i > 0 && !visited[i-1][j] && matrix[i-1][j] >= matrix[i][j]){
            water(wet, visited, matrix, i-1, j);
        }
        if(i < matrix.length-1 && !visited[i+1][j] && matrix[i+1][j] >= matrix[i][j]){
            water(wet, visited, matrix, i+1, j);
        }
        if(j > 0 && !visited[i][j-1] && matrix[i][j-1] >= matrix[i][j]){
            water(wet, visited, matrix, i, j-1);
        }
        if(j < matrix[0].length-1 && !visited[i][j+1] && matrix[i][j+1] >= matrix[i][j]){
            water(wet, visited, matrix, i, j+1);
        }
    }
}
