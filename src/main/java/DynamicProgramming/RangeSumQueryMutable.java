package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Array is mutable
 *
 * Solved using segment tree
 */
public class RangeSumQueryMutable {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        int[] segmentTree = new int[max_size];

        constructTree(arr, segmentTree, 0, arr.length-1, 0);
        System.out.println(Arrays.toString(segmentTree));
        System.out.println(query(segmentTree, 1, 3, 0, arr.length-1, 0));

        // Update: set arr[1] = 10 and update corresponding segment
        updateValue(segmentTree, arr, 1, 10);

        System.out.println(query(segmentTree, 1, 3, 0, arr.length-1, 0));
    }



    private static void updateValue(int[] segTree, int[] arr, int i, int newVal) {
        int diff = newVal - arr[i];
        arr[i] = newVal;
        updateValueUtil(segTree, 0, arr.length-1, i, diff, 0);
    }

    private static void updateValueUtil(int[] segTree, int low, int high, int i, int diff, int pos) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < low || i > high)
            return;

        // If the input index is in range of this node, then update the
        // value of the node and its children
        segTree[pos] = segTree[pos] + diff;
        if (low != high) {
            int mid = (low+high)/2;
            updateValueUtil(segTree, low, mid, i, diff, 2 * pos + 1);
            updateValueUtil(segTree, mid + 1, high, i, diff, 2 * pos + 2);
        }
    }

    private static int query(int[] segmentTree, int qlow, int qhigh, int low, int high, int pos) {
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return 0;
        }
        int mid = (low+high)/2;
        return query(segmentTree, qlow, qhigh, low, mid, pos*2+1) +
                query(segmentTree, qlow, qhigh, mid+1, high, pos*2+2);
    }

    private static void constructTree(int[] arr, int[] segmentTree, int low, int high, int pos) {
        if(low == high) {
            segmentTree[pos] = arr[low];
            return;
        }
        int mid = (low+high)/2;

        constructTree(arr, segmentTree, low, mid, pos*2+1);
        constructTree(arr, segmentTree, mid+1, high, pos*2+2);
        segmentTree[pos] = segmentTree[pos*2+1] + segmentTree[pos*2+2];
    }
}
