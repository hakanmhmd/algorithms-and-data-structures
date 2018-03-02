package GameTheory;

/**
 * Created by hakanmehmed on 02/03/2018.
 */
public class Sudoku {
    public static void main(String[] args) {
        char[][] matrix={
                {'5','3','4','6','.','.','.','.','2'},
                {'6','7','2','1','9','5','3','4','8'},
                {'1','9','.','3','4','2','5','6','7'},
                {'8','5','.','7','6','1','4','2','3'},
                {'4','2','6','.','5','3','7','9','1'},
                {'7','1','3','9','.','4','8','5','6'},
                {'9','6','1','5','.','7','2','8','4'},
                {'2','8','7','.','1','9','6','3','5'},
                {'.','4','5','2','8','6','1','7','9'}
        };

        System.out.println(isValidBoard(matrix));
    }

    private static boolean isValidBoard(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        //each row
        for (int i = 0; i < 9; i++) {
            boolean[] v = new boolean[9];
            for (int j = 0; j < v.length; j++) {
                if(board[i][j] != '.'){
                    if(v[board[i][j] - '1']){
                        System.out.println("Problem in row " + j);
                        return false;
                    }
                    v[board[i][j] - '1'] = true;
                }
            }
        }

        //each col
        for (int i = 0; i < 9; i++) {
            boolean[] v = new boolean[9];
            for (int j = 0; j < v.length; j++) {
                if(board[j][i] != '.'){
                    if(v[board[j][i] - '1']){
                        System.out.println("Problem in col " + i);
                        return false;
                    }
                    v[board[j][i] - '1'] = true;
                }
            }
        }

        //each 3x3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] v = new boolean[9];
            for (int i = block/3*3; i < block/3*3+3; i++) {
                for(int j=block%3*3;j<block%3*3+3; j++){
                    if(board[j][i] != '.'){
                        if(v[board[j][i] - '1']){
                            System.out.println("Problem in block " + block);
                            return false;
                        }
                        v[board[j][i] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
