package Arrays;

import java.util.Arrays;

/**
 * Created by hakanmehmed on 15/03/2018.
 */
public class ImageSmoother {
    public static void main(String[] args) {
        int[][] m = {
                {123,234,1},
                {1,0,1},
                {1,1,1}
        };

        int[][] smooth = imageSmoother(m);
        for (int[] ints : smooth) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] imageSmoother(int[][] M) {
        int[][] s = new int[M.length][M[0].length];
        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[0].length; j++){
                smoothCell(M, i, j, s);
            }
        }

        return s;
    }

    public static void smoothCell(int[][] grid, int row, int col, int[][] s){
        int count = 0;
        for(int i=row-1; i<=row+1; i++){
            for(int j=col-1; j<=col+1; j++){
                if(i >= 0 && j >= 0 && i <grid.length && j<grid[0].length){
                    s[row][col] += grid[i][j];
                    count++;
                }
            }
        }
        s[row][col] /= count;
    }
}
