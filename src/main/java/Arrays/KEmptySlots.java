package Arrays;

import java.util.Arrays;

/**
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
 * In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

 Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the
 flower will open in that day.

 For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where
 i and x will be in the range from 1 to N.

 Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
 and also the number of flowers between them is k and these flowers are not blooming.

 If there isn't such day, output -1.

 Intuition

 For each contiguous block ("window") of k positions in the flower bed, we know it satisfies the condition
 in the problem statement if the minimum blooming date of this window is larger than the blooming date of
 the left and right neighbors.

 Because these windows overlap, we can calculate these minimum queries more efficiently using a sliding window structure.
 */
public class KEmptySlots {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        System.out.println(kEmptySlots(arr, 1));
    }

    public static int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }
        System.out.println(Arrays.toString(days));

        int ans = Integer.MAX_VALUE;
        int left = 0, right = k+1;

        search: while (right < days.length) {
            for (int i = left+1; i < right; ++i) {
                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = i + k + 1;
                    continue search;
                }
            }
            ans = Math.min(ans, Math.max(days[left], days[right]));
            left = right;
            right = left + k + 1;
        }

        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}
