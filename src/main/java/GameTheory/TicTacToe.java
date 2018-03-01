package GameTheory;
import java.util.Arrays;
/**
 * Tic tac toe game
 */
public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe(){
        board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }
        currentPlayer = 'X';
    }

    private void printBoard() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();

        }
    }

    private boolean play(int row, int col){
        if(row < 0 || col < 0 || row >= 3 || col >= 3) return false;
        if(board[row][col] != '-') return false;
        board[row][col] = currentPlayer;
        return true;
    }

    private void changePlayer(){
        if(currentPlayer == 'X') currentPlayer = 'O';
        else currentPlayer = 'X';
    }

    private boolean hasWon(char player){
        return checkRows(player) || checkCols(player) || checkDiagonals(player);
    }

    private boolean checkDiagonals(char player) {
        if((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)){
            return true;
        }
        return false;
    }

    private boolean checkCols(char player) {
        for(int i=0; i<3; i++){
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                return true;
            }
        }
        return false;
    }

    private boolean checkRows(char player) {
        for(int i=0; i<3; i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.play(0,0);
        ttt.play(1,1);
        ttt.play(2,2);
        System.out.println(ttt.hasWon('X'));
        ttt.changePlayer();
        ttt.play(2, 0);
        ttt.play(1, 1);
        ttt.play(0, 2);
        System.out.println(ttt.hasWon('O'));
        ttt.printBoard();
    }
}
