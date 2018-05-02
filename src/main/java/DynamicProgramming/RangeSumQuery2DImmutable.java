package DynamicProgramming;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by
 * its upper left corner (row1, col1) and lower right corner (row2, col2).
 */
public class RangeSumQuery2DImmutable {
    int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];
        for(int i=1; i<rows; i++){
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }
        for(int i=1; i<cols; i++){
            dp[0][i] = matrix[0][i] + dp[0][i-1];
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = dp[row2][col2];

        if(row1 > 0){
            res -= dp[row1-1][col2];
        }

        if(col1>0){
            res -= dp[row2][col1-1];
        }
        if(row1>0 && col1>0){
            res += dp[row1-1][col1-1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] m = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        RangeSumQuery2DImmutable obj = new RangeSumQuery2DImmutable(m);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}
