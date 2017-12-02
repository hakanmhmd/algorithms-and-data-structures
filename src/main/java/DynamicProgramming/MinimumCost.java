package DynamicProgramming;

import java.util.Arrays;

/**
 * There are N stations on route of a train. The train goes from station 0 to N-1. The ticket cost
 * for all pair of stations (i, j) is given where j is greater than i.
 * Find the minimum cost to reach the destination.
 */
public class MinimumCost {
    static int INF = Integer.MAX_VALUE;
    public static void main(String args[])
    {
        int cost[][] = {
                {0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        System.out.println("The Minimum cost to reach station "+ cost.length +
                " is "+ minCostFast(cost));
    }

    private static int minCostFast(int[][] cost){
        int[] dist = new int[cost.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = INF;
        }
        dist[0] = 0;
        dist[1] = cost[0][1];
        for (int i = 2; i < dist.length; i++) {
            for(int j = i-1; j>=0; j--) {
                int x = dist[j] + cost[j][i];
                if(x < dist[i]){
                    dist[i] = x;
                }
            }
        }

        return dist[dist.length-1];
    }

    private static int minCost(int[][] cost) {
        return minCost(cost, 0, cost.length-1);
    }

    private static int minCost(int[][] cost, int s, int d) {
        if(s == d || s+1 == d){
            return cost[s][d];
        }
        int min = cost[s][d];

        for(int i=s+1; i<d; i++){
            int c = minCost(cost, s, i) + minCost(cost, i, d);
            if(c < min){
                min = c;
            }
        }
        return min;
    }
}
