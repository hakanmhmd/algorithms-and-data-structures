package DynamicProgramming;

/**
 * Given a set of numbers and target sum return true if any subset of these numbers can sum up to the target
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {1,3,6,9};
        int target = 9;

        System.out.println(subsetSum(arr, target));
    }

    private static boolean subsetSum(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length+1][target+1];

        // if subset if empty we cant sum up to target
        for(int i=1; i<=target; i++){
            dp[0][i] = false;
        }

        // if target is 0 we can get by taking the empty subset
        for(int i=0; i<=arr.length; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<=arr.length; i++){
            for(int j=1; j<=target; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][target];
    }
}
