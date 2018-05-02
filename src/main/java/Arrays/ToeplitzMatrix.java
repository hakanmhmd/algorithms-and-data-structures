package Arrays;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

 Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] m = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };

        System.out.println(isToeplitz(m));
    }

    private static boolean isToeplitz(int[][] m) {
        for(int i=1; i<m.length; i++){
            for(int j=1; j<m[i].length; j++){
                if(m[i][j] != m[i-1][j-1]) return false;
            }
        }
        return true;
    }
}
