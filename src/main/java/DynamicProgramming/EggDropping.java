package DynamicProgramming;

/**
 * When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
 * <p>
 * 1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower
 * than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
 * 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for
 * floors higher than x; so the problem reduces to k-x floors and n eggs.
 */
public class EggDropping {
    public static void main(String[] args) {
        int n = 2, k = 10;

        System.out.println(eggDrop(n, k));
        System.out.println(eggDropDP(n, k));
    }

    private static int eggDrop(int eggs, int floors) {
        // if 1 egg is left try each floor sequentially
        // if one floor is left try it
        if(floors == 0 || floors == 1 || eggs == 1) return floors;

        // try dropping from each floor and take the min
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=floors; i++){
            int res = 1 + Math.max(eggDrop(eggs-1, i-1), eggDrop(eggs, floors-i));
            min = Math.min(min, res);
        }

        return min;
    }

    private static int eggDropDP(int eggs, int floors) {
        // if one floor is left try it
        int[][] dp = new int[eggs+1][floors+1];
        for (int i = 1; i <= eggs; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        // We always need i trials for one egg and i floors.
        for(int i=1; i<=floors; i++){
            dp[1][i] = i;
        }

        for(int i=2; i<=eggs; i++){
            for(int j=2; j<=floors; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1; x<=j; x++) {
                    int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                    if(res < dp[i][j]){
                        dp[i][j] = res;
                    }
                }
            }
        }

        return dp[eggs][floors];
    }
}
