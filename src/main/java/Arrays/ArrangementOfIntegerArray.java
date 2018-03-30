package Arrays;

import java.util.Arrays;

/**
 * Given two integers n and k, you need to construct a list which contains n different
 * positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
 * has exactly k distinct integers.
 */
public class ArrangementOfIntegerArray {
    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        System.out.println(Arrays.toString(constructArray(n, k)));
    }

    /**
     *
     When k = n-1, a valid construction is [1, n, 2, n-1, 3, n-2, ....].
     One way to see this is, we need to have a difference of n-1, which means we need 1 and
     \text{n}n adjacent; then, we need a difference of n-2, etc.

     Also, when k = 1, a valid construction is [1, 2, 3, ..., n].
     So we have a construction when \text{n-k}n-k is tiny, and when it is large. This leads to the idea
     that we can stitch together these two constructions: we can put [1, 2, ..., n-k-1]
     first so that n is effectively k+1, and then finish the construction with the first
     "k = n-1" method.

     For example, when \text{n = 6}n = 6 and \text{k = 3}k = 3, we will construct the array as
     [1, 2, 3, 6, 4, 5]. This consists of two parts: a construction of [1, 2]
     and a construction of [1, 4, 2, 3] where every element had 2 added to it
     (i.e. [3, 6, 4, 5]).
     */
    public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int c=0;
        for(int i=1; i<n-k; i++){
            ans[c] = i;
            c++;
        }

        for(int i=0; i<k+1; i++){
            ans[c] = (i%2==0) ? n-k+i/2 : n-i/2;
            c++;
        }
        return ans;

    }
}

