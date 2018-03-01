package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts the array.
 *
 * Insertion sort - O(nk), good for small values of k, not recommended for large
 * Use heap data strcuture
 */
public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,2,3,7,8,6,10,9};
        int k = 2;

        sort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        int index = 0;
        for(int i=k+1; i <arr.length; i++){
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while(!pq.isEmpty()){
            arr[index++] = pq.poll();
        }
    }
}
