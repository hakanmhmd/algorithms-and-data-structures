package Arrays;

/**
 * Rotate a matrix 90 degrees to the right
 */
public class MatrixRotation {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        rotateLeftMatrix(matrix);
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateRightMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return;

        int n = matrix.length;

        for (int i = 0; i < n/2; i++) {
            int firstElement = i;
            int lastElement = n-i-1;
            for (int j = firstElement; j < lastElement; j++) {
                int offset = j - firstElement;
                int top = matrix[firstElement][j]; // save the element from the top layer

                // left -> top
                matrix[firstElement][j] = matrix[lastElement-offset][firstElement];
                // bottom -> left
                matrix[lastElement-offset][firstElement] = matrix[lastElement][lastElement-offset];
                // right -> bottom
                matrix[lastElement][lastElement-offset] = matrix[j][lastElement];
                // top -> right
                matrix[j][lastElement] = top;

            }
        }

    }

    private static void rotateLeftMatrix(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length != matrix.length) return;

        int n = matrix.length;
        for(int i=0; i<n/2; i++){
            int firstElement = i;
            int lastElement = n-i-1;

            for(int j=firstElement; j<lastElement; j++){
                int right = matrix[j][lastElement];

                //bottom->right
                matrix[j][lastElement] = matrix[lastElement][n-1-j];

                //left->bottom
                matrix[lastElement][n-1-j] = matrix[n-1-j][firstElement];

                //top->left
                matrix[n-1-j][firstElement] = matrix[firstElement][j];

                //right->top
                matrix[firstElement][j] = right;
            }
        }
    }
}
