package Tree;

import java.util.Arrays;
/**
 * Compute how many unique BSTs can be generated provided with nodes 1...n
 */
public class NumberOfUniqueBST {
    public static void main(String[] args) {
        int n = 3;
        int[] p = new int[n];
        Arrays.fill(p, -1);
        System.out.println(totalBSTs(n, p));
    }

    private static int totalBSTs(int n, int[] p) {
        if(n == 0 || n == 1) return 1; // basecase

        int possibilities = 0;

        for(int i=0; i<n; i++){
            if(p[i] == -1){
                p[i] = totalBSTs(i ,p);
            }

            if(p[n-i-1] == -1){
                p[n-i-1] = totalBSTs(n-i-1, p);
            }

            possibilities += p[i] * p[n-i-1];
        }

        return possibilities;
    }
}
