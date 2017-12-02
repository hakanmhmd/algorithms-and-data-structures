package Arrays;

import com.sun.tools.javac.util.Pair;

/**
 * Created by hakanmehmed on 02/12/2017.
 */
public class SubmatrixInMatrix {
    public static void main(String[] args) {
        int a[][] = {
                { 2, 3, 5, 7 },
                { 5, 8, 3, 5 },
                { 7, 6, 9, 2 },
                { 3, 8, 5, 9 }
        };
        int b[][] = {
                { 5, 7 },
                { 3, 5 },
                { 9, 2 }
        };

        Pair<Integer, Integer> index = findSubmatrix(a, b);
        if(index == null){
            System.out.println("Matrix not found.");
        } else {
            System.out.println("Found at [" + index.fst + ", " + index.snd + "]");
        }
    }

    private static Pair<Integer, Integer> findSubmatrix(int[][] a, int[][] b) {

        for (int i = 0; i <= a.length - b.length; i++) {
            for (int j = 0; j <= a[0].length - b[0].length; j++) {
                if(a[i][j] == b[0][0]){
                    if(trueCandidate(i, j, a, b)){ // i,j is a candidate
                        return new Pair<>(i, j);
                    }
                }
            }
        }
        return null;
    }

    private static boolean trueCandidate(int i, int j, int[][] a, int[][] b) {
        for (int k = 0; k < b.length; k++) {
            for (int l = 0; l < b[0].length; l++) {
                if(a[i+k][j+l] != b[k][l]){
                    return false;
                }
            }
        }
        return true;
    }
}
