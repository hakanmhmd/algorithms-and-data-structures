package Arrays;

/**
 * There are N coins kept on the table, numbered from 0 to N - 1. Initially, each coin is kept tails up.
 * You have to perform two types of operations:
 * <p>
 * 1) Flip all coins numbered between A and B inclusive. This is represented by the command "0 A B"
 * 2) Answer how many coins numbered between A and B inclusive are heads up. This is represented by the command "1 A B".
 */
public class FlippingCoins {
    public static void main(String[] args) {
        int n = 4;
        String[] ops = {
                "1 0 3",
                "0 1 2",
                "1 0 1",
                "1 0 0",
                "0 0 3",
                "1 0 3",
                "1 3 3"
        };

        run(n, ops);
    }

    private static void run(int n, String[] ops) {
        int x = (int) (Math.log(n) / Math.log(2));
        int[] segmentTree = new int[2 * (int) Math.pow(2, x) - 1];
        int[] arr = new int[n];
        constructSegmentTree(segmentTree, arr, 0, n - 1, 0);
        for (String op : ops) {
            String[] parts = op.split(" ");
            if (Integer.parseInt(parts[0]) == 0) {
                flipCoins(segmentTree, arr, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            } else {
                int res = query(segmentTree, 0, n - 1, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), 0);
                System.out.println(res);
            }
        }
    }

    private static void flipCoins(int[] segmentTree, int[] arr, int start, int end) {
        for(int i=start; i<=end; i++){
            int diff = arr[i] == 0 ? 1 : -1;
            arr[i] = arr[i] == 0 ? 1 : 0;
            updateValUtil(segmentTree, 0, arr.length-1, i, diff, 0);
        }
    }

    private static void updateValUtil(int[] segmentTree, int low, int high, int i, int diff, int pos) {
        if(i<low || i>high) return;
        segmentTree[pos] = segmentTree[pos] + diff;
        if(low != high){
            int mid = (low+high)/2;
            updateValUtil(segmentTree, low, mid, i, diff, 2*pos+1);
            updateValUtil(segmentTree, mid+1, high, i, diff, 2*pos+2);
        }
    }

    private static int query(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos) {
        if (qlow <= low && qhigh >= high) return segmentTree[pos];
        if (qlow > high || qhigh < low) return 0;
        int mid = (low + high) / 2;

        return query(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1)
                + query(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2);
    }

    private static void constructSegmentTree(int[] segmentTree, int[] arr, int start, int end, int pos) {
        if (start == end) {
            segmentTree[pos] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        constructSegmentTree(segmentTree, arr, start, mid, 2 * pos + 1);
        constructSegmentTree(segmentTree, arr, mid + 1, end, 2 * pos + 2);
        segmentTree[pos] = segmentTree[pos * 2 + 1] + segmentTree[pos * 2 + 2];
    }
}
