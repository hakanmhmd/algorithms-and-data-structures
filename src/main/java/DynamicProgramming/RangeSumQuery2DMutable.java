package DynamicProgramming;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper
 * left corner (row1, col1) and lower right corner (row2, col2).
 *
 * O(m) + O(n)
 * Can keep row or col sums
 */
public class RangeSumQuery2DMutable {
    int[][] colSums; // sum of columns
    int[][] matrix;
    public RangeSumQuery2DMutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        colSums = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(i == 0){
                    colSums[i][j] = matrix[i][j];
                } else {
                    colSums[i][j] = matrix[i][j] + colSums[i-1][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        RangeSumQuery2DMutable obj = new RangeSumQuery2DMutable(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        obj.update(3, 2, 2);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
    }

    private void update(int row, int col, int newVal) {
        int diff = newVal - matrix[row][col];
        for(int i=row; i<matrix.length; i++){
            colSums[i][col] = colSums[i][col] + diff;
        }

        matrix[row][col] = newVal;
    }

    private int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i=col1; i <= col2; i++){
            if(row1 == 0) res += colSums[row2][i];
            else res += colSums[row2][i] - colSums[row1-1][i];
        }

        return res;
    }
}
