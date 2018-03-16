package Arrays;

import java.util.Stack;

/**
 * Created by hakanmehmed on 14/03/2018.
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 */
public class MaxAreaIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };

        System.out.println(maxAreaOfIslandIterative(grid));
        System.out.println(maxAreaOfIsland(grid));

    }
    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    int area = calculateArea(i, j, grid, 1);
                    if(area > maxArea) maxArea = area;
                }
            }
        }

        return maxArea;
    }

    static int calculateArea(int row, int col, int[][] grid, int count){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] != 1){
            return 0;
        }

        grid[row][col] = -1;

        return 1 + calculateArea(row+1, col, grid, count+1) +
            calculateArea(row-1, col, grid, count+1) +
            calculateArea(row, col+1, grid, count+1) +
            calculateArea(row, col-1, grid, count+1);

    }

    public static int maxAreaOfIslandIterative(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int ans = 0;
        for (int r0 = 0; r0 < grid.length; r0++) {
            for (int c0 = 0; c0 < grid[0].length; c0++) {
                if (grid[r0][c0] == 1 && !seen[r0][c0]) {
                    int shape = 0;
                    Stack<int[]> stack = new Stack();
                    stack.push(new int[]{r0, c0});
                    seen[r0][c0] = true;
                    while (!stack.empty()) {
                        int[] node = stack.pop();
                        int r = node[0], c = node[1];
                        shape++;
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (0 <= nr && nr < grid.length &&
                                    0 <= nc && nc < grid[0].length &&
                                    grid[nr][nc] == 1 && !seen[nr][nc]) {
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, shape);
                }
            }
        }
        return ans;
    }
}
