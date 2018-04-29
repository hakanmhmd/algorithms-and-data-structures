package GameTheory;

/**
 * Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by
 * alternating turns. In each turn, a player selects either the first or last coin from the row, removes it
 * from the row permanently, and receives the value of the coin. Determine the maximum possible amount of
 * money we can definitely win if we move first.
 */
public class OptimalGameStrategy {
    public static void main(String[] args) {
        int[] arr = {8, 15, 3, 7};

        System.out.println(maxScore(arr, 0, arr.length-1));
        System.out.println(maxScoreDP(arr));
    }

    private static int maxScore(int[] arr, int i, int j) {
        if(i == j) return arr[i];
        if(i+1 == j) return Math.max(arr[i], arr[j]);

        return Math.max(arr[i] + Math.min(maxScore(arr, i+2, j), maxScore(arr, i+1, j-1)),
                        arr[j] + Math.min(maxScore(arr, i+1, j-1), maxScore(arr, i, j-2)));
    }

    private static int maxScoreDP(int[] arr){
        int n = arr.length;
        int[][] table = new int[n][n];

        int x,y,z;
        for (int gap = 0; gap < n; ++gap) {
            int j = gap;
            for (int i = 0; j < n; i++, j++){
                // Here x is value of F(i+2, j), y is F(i+1, j-1) and
                // z is F(i, j-2) in above recursive formula
                x = (i+2<n) ? table[i+2][j] : 0;
                y = (i+1<n && j-1>=0) ? table[i+1][j-1] : 0;
                z = (j-2>=0)? table[i][j-2]: 0;

                table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        return table[0][n-1];
    }
}
