package GameTheory;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * <p>
 * Checking for winner should be faster than O(n^2)
 */
public class TicTacToeDesign {
    int[][] rows;
    int[][] cols;
    int[] diag;
    int[] xdiag;

    int n;

    public TicTacToeDesign(int n) {
        this.rows = new int[2][n];
        this.cols = new int[2][n];
        this.diag = new int[n];
        this.xdiag = new int[n];
        this.n = n;
    }

    // returns the winner 1 or 2
    // 0 if there is no winner
    private int move(int row, int col, int player) throws Exception {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new Exception();
        }

        rows[player - 1][row]++;
        cols[player - 1][col]++;

        if (row == col) diag[player - 1]++;
        if (row + col == n - 1) xdiag[player - 1]++;

        if (rows[player - 1][row] == n || cols[player - 1][col] == n || diag[player - 1] == n || xdiag[player - 1] == n) {
            System.out.println("Winner: " + player);
            return player;
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        TicTacToeDesign toe = new TicTacToeDesign(3);

        toe.move(0, 0, 1);
        toe.move(0, 2, 2);
        toe.move(2, 2, 1);
        toe.move(1, 1, 2);
        toe.move(2, 0, 1);
        toe.move(1, 0, 2);
        toe.move(2, 1, 1);
    }
}
