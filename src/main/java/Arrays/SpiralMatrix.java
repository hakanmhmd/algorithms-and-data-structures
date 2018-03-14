package Arrays;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {6,10,11,12}
        };

        printSpiralMatrix(matrix);
    }

    private static void printSpiralMatrix(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        int i, j;
        while(top <= bottom && left <= right){
            for(j=left; j<=right; j++){
                System.out.print(matrix[top][j] + " ");
            }
            top += 1;

            for(i=top; i<=bottom; i++){
                System.out.print(matrix[i][right] + " ");
            }
            right -= 1;

            if(top<=bottom) {
                for (j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom -= 1;
            }

            if(left<=right) {
                for (i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left += 1;
            }
        }
    }
}
