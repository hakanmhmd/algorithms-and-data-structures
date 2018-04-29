package Backtracking;

/**
 * Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) to the
 * empty cells so that every row, column, and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9.
 */
public class Sudoku {
    public static void main(String[] args) {
        int grid[][] = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        System.out.println(solve(grid));
    }

    private static boolean solve(int[][] grid) {

        int[] slot = findEmptySlot(grid);
        if(slot == null) return true;
        int row = slot[0];
        int col = slot[1];

        for(int x=1; x<=9; x++) {
            if (isSafe(grid, row, col, x)) {
                grid[row][col] = x;
                if (solve(grid)) return true;
                grid[row][col] = 0;
            }
        }
        return false;

    }

    private static int[] findEmptySlot(int[][] grid){
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        for(int i=0; i<grid.length; i++){
            if(grid[i][col] == num) {
                return false;
            }
        }
        for(int i=0; i<grid[0].length; i++){
            if(grid[row][i] == num) {
                return false;
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(grid[i+(row-row%3)][j+(col-col%3)] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
