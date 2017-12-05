package Arrays;

/**
 * Given a 2-d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically and diagonally. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public static void main (String[] args) throws java.lang.Exception
    {
        int m[][]=  new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1}
        };

        System.out.println("Number of islands is: "+ countIslands(m));
    }

    private static int countIslands(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if(m[i][j] == 1){
                    count++;
                    merge(m, i, j);
                }
            }
        }
        return count;
    }

    private static void merge(int[][] m, int i, int j) {
        if(i<0||i>=m.length||j<0||j>=m[0].length||m[i][j]!=1) {
            return;
        }
        m[i][j] = -1;
        merge(m, i, j-1);
        merge(m, i, j+1);
        merge(m, i-1, j);
        merge(m, i+1, j);
        merge(m, i+1, j-1);
        merge(m, i+1, j+1);
        merge(m, i-1, j-1);
        merge(m, i-1, j+1);
    }
}
