package Arrays;

/**
 *Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into
 * some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them,
 * the result equals the sorted array.
 */
public class MaxChunkToSort {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1};
        System.out.println(maxChunksToSorted(arr));
        System.out.println(maxChunksToSorted2(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }

    /**
     original: 0, 2, 1, 4, 3, 5, 7, 6
     max:      0, 2, 2, 4, 4, 5, 7, 7
     sorted:   0, 1, 2, 3, 4, 5, 6, 7
     index:    0, 1, 2, 3, 4, 5, 6, 7
     */
    public static int maxChunksToSorted2(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
}
