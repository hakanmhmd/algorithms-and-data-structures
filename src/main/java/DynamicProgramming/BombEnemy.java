package DynamicProgramming;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the
 * maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the
 wall since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.
 */
public class BombEnemy {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };

        System.out.println(killEnemies(grid));
    }

    private static int killEnemies(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows == 0 || cols == 0) return 0;
        int rowKills = 0;
        int[] colKills = new int[cols];

        int max = Integer.MIN_VALUE;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 'W') continue;

                if(i==0 || grid[i-1][j] == 'W'){
                    // recalculate colKills[j]
                    colKills[j] = 0;
                    for(int k=i; k<rows && grid[k][j] != 'W'; k++){
                        if(grid[k][j] == 'E') colKills[j]++;
                    }

                }

                if(j==0 || grid[i][j-1] == 'W'){
                    // recalculate rowKills
                    rowKills = 0;
                    for(int k=j; k<cols && grid[i][k] != 'W'; k++){
                        if(grid[i][k] == 'E') rowKills++;
                    }
                }

                if(grid[i][j] == '0'){
                    max = Math.max(max, rowKills + colKills[j]);
                }
            }
        }

        return max;
    }
}
