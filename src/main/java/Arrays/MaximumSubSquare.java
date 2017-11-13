package Arrays;

/**
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 */
public class MaximumSubSquare {

    public static void main(String[] args)
    {
        int M[][] =  {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        printMaxSubSquare(M);
    }

    private static void printMaxSubSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] aux = new int[rows][cols];

        // copy first row
        for(int i=0; i<cols; i++){
            aux[0][i] = matrix[0][i];
        }

        //copy first col
        for(int i=0; i<rows; i++){
            aux[i][0] = matrix[i][0];
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][j] == 1){
                    aux[i][j] = Math.min(Math.min(aux[i-1][j], aux[i-1][j-1]), aux[i][j-1]) + 1;
                } else {
                    aux[i][j] = 0;
                }
            }
        }


        int maxRow = 0;
        int maxCol = 0;
        int maxSquareLen = aux[0][0];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(maxSquareLen < aux[i][j]){
                    maxSquareLen = aux[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Max sub matrix: ");

        int startRow = maxRow - maxSquareLen + 1;
        int startCol = maxCol - maxSquareLen + 1;
        for(int i=startRow; i<startRow+maxSquareLen; i++){
            for(int j=startCol; j<startCol+maxSquareLen; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
