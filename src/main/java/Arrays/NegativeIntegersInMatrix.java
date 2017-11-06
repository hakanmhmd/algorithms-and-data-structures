package Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Find the number of negative integers in a row-wise/col-wise sorted matrix
 * Naive solution - O(nm)
 */
public class NegativeIntegersInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {-3, -2, -1, 1},
                {-2, 2, 3, 4},
                {4, 5, 7, 8}
        };

        assertTrue(findNegativeNums(matrix, matrix[0].length, matrix.length) == 4);
    }

    private static int findNegativeNums(int[][] matrix, int m, int n) {
        int i = 0;
        int j = m-1;
        int count = 0;
        while(j>=0 && i < n){
            if(matrix[i][j] < 0){
                count += (j+1);
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
