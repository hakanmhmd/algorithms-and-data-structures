package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may
 assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
 it should be filled with INF.
 */
public class WallsAndGates {
    private static final int INF = Integer.MAX_VALUE;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    
    public static void main(String[] args) {
        int[][] grid = {
                {INF,  -1,  0,  INF},
                {INF, INF, INF,  -1},
                {INF,  -1, INF,  -1},
                {0, -1, INF, INF}
        };

        findDistance(grid);

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // BFS from each 0 point
    private static void findDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];

            for(int[] dir: DIRECTIONS){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow<0||newCol<0||newRow>=m||newCol>=n||grid[newRow][newCol] != Integer.MAX_VALUE){
                    continue;
                }

                grid[newRow][newCol] = grid[row][col] + 1;
                q.offer(new int[]{newRow, newCol});
            }
        }
        
    }
}
