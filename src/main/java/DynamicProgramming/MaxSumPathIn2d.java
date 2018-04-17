package DynamicProgramming;

/**
 * Given a matrix of N * M. Find the maximum path sum in matrix. The maximum path is sum of all elements
 * from first row to last row where you are allowed to move only down or diagonally to left or right.
 * You can start from any element in first row.
 */
public class MaxSumPathIn2d {
    public static void main(String[] args) {
        int matrix[][] = {
                { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };

        System.out.println(maxSum(matrix));
    }

    private static int maxSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0) return -1;

        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(j==0){
                    matrix[i][j] += Math.max(matrix[i-1][j], matrix[i-1][j+1]);
                } else if(j==matrix[0].length-1){
                    matrix[i][j] += Math.max(matrix[i-1][j], matrix[i-1][j-1]);
                } else {
                    matrix[i][j] += Math.max(matrix[i-1][j], Math.max(matrix[i-1][j+1], matrix[i-1][j-1]));
                }
            }
        }

        int res = 0;
        for(int i=0; i<matrix[0].length; i++){
            res = Math.max(res, matrix[matrix.length-1][i]);
        }

        return res;
    }
}
