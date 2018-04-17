package DynamicProgramming;

/**
 * Given a 2D matrix find the path with the maximum product.
 */
public class MaxProductPath2D {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, -5},
                {4, 8, 20},
                {-50, 10, -2}
        };

        System.out.println(maxProduct(matrix));
    }

    private static int maxProduct(int[][] matrix) {
        int[][][] dp = new int[matrix.length][matrix[0].length][2];

        dp[0][0][0] = dp[0][0][1] = matrix[0][0];

        for(int i=1; i<matrix.length; i++){
            dp[i][0][0] = dp[i][0][1] = dp[i-1][0][0] * matrix[i][0];
        }

        for(int j=1; j<matrix[0].length; j++){
            dp[0][j][0] = dp[0][j][1] = dp[0][j-1][0] * matrix[0][j];
        }
        //dp[i][j][0] stores current positive max product
        //d[[i][j][1] stores current negative min product
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix.length; j++){
                if(matrix[i][j] > 0){
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i][j-1][0]) * matrix[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][1], dp[i][j-1][1]) * matrix[i][j];
                } else {
                    dp[i][j][1] = Math.max(dp[i-1][j][0], dp[i][j-1][0]) * matrix[i][j];
                    dp[i][j][0] = Math.min(dp[i-1][j][1], dp[i][j-1][1]) * matrix[i][j];
                }
            }
        }

        return dp[matrix.length-1][matrix[0].length-1][0];

    }
}
