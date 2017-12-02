package Arrays;

/**
 * Multiply two matrices
 */
public class MultiplyMatrices {
    public static void main(String[] args) {
        int[][] firstMatrix = { {3, -2, 5}, {3, 0, 4} };
        int[][] secondMatrix = { {2, 3}, {-9, 0}, {0, 4} };

        int[][] product = null;
        try {
            product = multiplyMatrices(firstMatrix, secondMatrix);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product[0].length; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) throws Exception {
        if(firstMatrix == null || secondMatrix == null ||
                firstMatrix.length == 0 || firstMatrix[0].length == 0 ||
                secondMatrix.length == 0 || secondMatrix[0].length == 0){
            return null;
        }

        int m1 = firstMatrix.length;
        int n1 = firstMatrix[0].length;
        int m2 = secondMatrix.length;
        int n2 = secondMatrix[0].length;

        if(n1 != m2){
            throw new Exception("Cant multiply these matrices");
        }
        int[][] product = new int[m1][n2];

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }
}
