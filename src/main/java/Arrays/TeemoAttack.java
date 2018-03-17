package Arrays;

/**
 * Created by hakanmehmed on 16/03/2018.
 */
public class TeemoAttack {
    public static void main(String[] args) {
        int[] time = {1, 2};
        int d = 2;

        System.out.println(findPoisonedDuration(time, d));
        System.out.println(findPoisonedDuration2(time, d));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
        int start = timeSeries[0];
        int end = start + duration;

        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                res += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        res += end - start;
        return res;
    }

    public static int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
        int res = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(timeSeries[i] - timeSeries[i-1], duration);
        }
        return res;
    }
}
