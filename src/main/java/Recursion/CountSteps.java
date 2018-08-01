package Recursion;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either
 * 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
 */
public class CountSteps {
    public static void main(String[] args) {
        int stairs = 5;
        int[] steps = {1,3,5};

        System.out.println(countPossibleWays(stairs, steps));
    }

    private static int countPossibleWays(int stairs, int[] steps) {
        if(stairs < 0) return 0;
        if(stairs <= 1) return 1;
        int res = 0;
        for(int i=0; i<steps.length; i++){
            res += countPossibleWays(stairs - steps[i], steps);
        }
        return res;
    }
}
