package DynamicProgramming;

import java.util.Arrays;

/**
 * Given a 2D array, find the maximum sum subarray in it.
 * O(col*col*row) solution using Kadane's algorithm
 * O(row) space
 */
public class MaxSumRectangularMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
        };

        int max = findMaxSubMatrix(matrix);
        System.out.println(max);

        matrix = new int[][]{
                {2, 1, -3, -4, 5},
                {0, 6, 3, 4, 1},
                {2, -2, -1, 4, -5},
                {-3, 3, 0, 1, 3}
        };

        max = findMaxSubMatrix(matrix);
        System.out.println(max);

    }

    private static int findMaxSubMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;
        int maxUp = 0;
        int maxDown = 0;

        int[] temp = new int[rows];
        for (int i = 0; i < cols; i++) {
            Arrays.fill(temp, 0);
            for (int j = i; j < cols; j++) {
                updateTempArray(matrix, temp, j);
                int[] result = kadane(temp);
                currentSum = result[2];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    maxLeft = i;
                    maxRight = j;
                    maxUp = result[0];
                    maxDown = result[1];
                }
            }
        }

        System.out.println("Max sum sub rectangular matrix: ");
        for (int i = maxUp; i <= maxDown; i++) {
            for (int j = maxLeft; j <= maxRight; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return maxSum;
    }

    private static void updateTempArray(int[][] matrix, int[] temp, int col) {
        for (int i = 0; i < temp.length; i++) {
            temp[i] += matrix[i][col];
        }
    }

    private static int[] kadane(int[] arr) {
        int max = 0, maxSoFar = 0;
        int start = 0;
        int end = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];
            if(maxSoFar < 0) {
                maxSoFar = 0;
                temp = i+1;
            }

            if(maxSoFar > max) {
                max = maxSoFar;
                end = i;
                start = temp;
            }
        }

        return new int[] {start, end, max};
    }
}
