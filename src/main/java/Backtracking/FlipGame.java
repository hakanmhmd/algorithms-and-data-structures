package Backtracking;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these
 * two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to determine if the starting player can guarantee a win.
 */
public class FlipGame {
    public static void main(String[] args) {
        String s = "++++";
        System.out.println(canWin(s));
    }

    private static boolean canWin(String s) {
        if(s==null || s.length()==0) return false;

        return canWinHelper(s.toCharArray());
    }

    private static boolean canWinHelper(char[] arr) {
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == '+' && arr[i+1] == '+'){
                arr[i] = '-';
                arr[i+1] = '-';

                boolean canWin = canWinHelper(arr);

                arr[i] = '+';
                arr[i+1] = '+';

               if(!canWin) return true;
            }
        }
        return false;
    }


}
