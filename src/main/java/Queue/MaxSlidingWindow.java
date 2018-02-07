package Queue;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/queries-with-fixed-length/problem
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        for(int x=0; x<q; x++){
            int window = in.nextInt();
            System.out.println(minSlidingWindowMax(arr, window));
        }

    }


    public static int minSlidingWindowMax(final int[] in, final int w) {
        final int[] max_left = new int[in.length];
        final int[] max_right = new int[in.length];

        max_left[0] = in[0];
        max_right[in.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

            final int j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
        }

        final int[] sliding_max = new int[in.length - w + 1];
        int min_sliding_max = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_max[j] = Math.max(max_right[i], max_left[i + w - 1]);
            if(sliding_max[j] < min_sliding_max) min_sliding_max = sliding_max[j];
            j++;
        }

        return min_sliding_max;
    }

    // Can also be solved using a queue
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) return null;
        int[] res = new int[a.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int index  = 0;
        for (int i = 0; i < a.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) // Ensure deque's size doesn't exceed k
                deque.poll();

            // Remove numbers smaller than a[i] from right(a[i-1]) to left, to make the first number in the deque the largest one in the window
            while (!deque.isEmpty() && a[deque.peekLast()] < a[i])
                deque.pollLast();

            deque.offer(i);// Offer the current index to the deque's tail

            if (i >= k - 1)// Starts recording when i is big enough to make the window has k elements
                res[index++] = a[deque.peek()];
        }
        return res;
    }
}
