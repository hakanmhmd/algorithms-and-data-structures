package Tree;

import java.util.Arrays;

/**
 * Constrcuting segment tree from an input array
 */
public class SegmentTreeMinRangeQuery {
    public static void main(String[] args) {
        int[] arr = {-1,2,4,0};
        int[] segmentTree = new int[arr.length*2-1];
        construct(arr, segmentTree, 0, arr.length-1, 0);

        System.out.println(Arrays.toString(segmentTree));

        System.out.println(minRangeQuery(segmentTree, 1, 3, 0, arr.length-1, 0));
    }

    private static void construct(int[] arr, int[] segmentTree, int start, int end, int pos) {
        if(start == end) {
            segmentTree[pos] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        construct(arr, segmentTree,start, mid, 2*pos+1);
        construct(arr, segmentTree,mid+1, end, 2*pos+2);
        segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
    }

    static int minRangeQuery(int[] segTree, int qlow, int qhigh, int low, int high, int pos){
        if(qlow <= low && qhigh >= high){
            //total overlap
            return segTree[pos];
        }
        if(qlow > high || qhigh < low) {
            //no overlap
            return Integer.MAX_VALUE;
        }

        int mid = (low+high)/2;

        return Math.min(minRangeQuery(segTree, qlow, qhigh, low, mid, pos*2+1),
                minRangeQuery(segTree, qlow, qhigh, mid+1, high, pos*2+2));
    }

}
