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

    // 1,2,3,4
    // s(4) = bst 1 as root + bst 2 as root + bst 3 as root + bst 4 as root
    // bst 3 as root = s(2) * s(1)
    // => s(4) = s(0) * s(3) + s(1) * s(2) + s(2) * s(1) + s(3) + s(0)
    private static int totalBSTs(int n, int[] p) {
        if(n == 0 || n == 1) return 1; // base case - only 1 bst exist

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
