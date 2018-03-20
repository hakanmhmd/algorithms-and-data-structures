package DynamicProgramming;

import java.util.ArrayList;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get
 * the maximum total value in the knapsack. In other words, given two integer arrays
 * val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items
 * respectively. Also given an integer W which represents knapsack capacity, find out the
 * maximum value subset of val[] such that sum of the weights of this subset is smaller
 * than or equal to W
 */
public class Knapsack {
    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(knapSackRec(W, wt, val, 0));
    }

    private static int knapSackRec(int W, int[] wt, int[] val, int n){
        if(n == wt.length || W == 0){
            return 0;
        }
        if(wt[n] > W) {
            // cant include it
            return knapSackRec(W, wt, val, n+1);
        }
        // try including and excluding the n item

        int included = val[n] + knapSackRec(W-wt[n], wt, val, n+1);
        int excluded = knapSackRec(W, wt, val, n+1);

        return Math.max(included, excluded);
    }

    private static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n+1][W+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                } else if(wt[i-1] <= j){
                    K[i][j] = max(val[i-1] + K[i-1][j-wt[i-1]], K[i-1][j]);
                } else {
                    K[i][j] = K[i-1][j];
                }
            }
        }

        ArrayList<Integer> items = new ArrayList<>();
        int i = n;
        int j = W;
        while(i>=0 && j>= 0 && K[i][j] != 0){
            while(K[i][j] == K[i-1][j]){
                i = i-1;
            }
            items.add(wt[i-1]);
            j = j - wt[i-1];
        }

        System.out.println("Items: ");
        for (int k = 0; k < items.size(); k++) {
            System.out.print(items.get(k) + " ");
        }
        System.out.println();

        return K[n][W];
    }

    private static int max(int a, int b) {
        return (a>b) ? a : b;
    }
}
