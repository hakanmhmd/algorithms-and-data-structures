package DynamicProgramming;

/**
 * Given a paper of size A x B. Task is to cut the paper into squares of any size.
 * Find the minimum number of squares that can be cut from the paper.
 */
public class PaperCutMinSquares {
    public static void main(String[] args) {
        int m = 30, n = 36;

        System.out.println(squares(m, n, new int[m+1][n+1]));
        System.out.println(squaresGreedy(m, n));
    }

    // dp - optimal solution
    private static int squares(int m, int n, int[][] dp) {
        if(m == n) return 1;

        if(dp[m][n] != 0) return dp[m][n];

        int vertical_min = Integer.MAX_VALUE;
        int horizontal_min = Integer.MAX_VALUE;
        for(int i=1; i<=m/2; i++){
            horizontal_min = Math.min(horizontal_min, squares(m-i, n, dp) + squares(i, n, dp));
        }

        for(int i=1; i<=n/2; i++){
            vertical_min = Math.min(vertical_min, squares(m, n-i, dp) + squares(m, i, dp));
        }

        dp[m][n] = Math.min(vertical_min, horizontal_min);

        return dp[m][n];
    }

    //greedy - non optimal
    //or example if paper have the size 13 x 29, then maximum square will be of side 13.
    // so we can cut 2 square of size 13 x 13 (29/13 = 2). Now remaining paper will have
    // size 3 x 13. Similarly we can cut remaining paper by using 4 squares of size 3 x 3
    // and 3 squares of 1 x 1. So minimum 9 squares can be cut from the Paper of size 13 x 29.
    private static int squaresGreedy(int m, int n) {
        int result = 0, rem = 0;
        if(m < n){
            int temp = m;
            m = n;
            n = temp;
        }
        //n is smaller
        // iterate until small size is > 0
        while(n>0){
            result += m/n;
            rem = m % n;
            m = n;
            n = rem;
        }

        return result;
    }
}
