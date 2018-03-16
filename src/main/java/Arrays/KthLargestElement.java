package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hakanmehmed on 31/10/2017.
 */
public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15, 16, 17, 22};
        System.out.println(Arrays.toString(arr));
        int k = 3;
        System.out.println(findKthLargestSort(arr, k));
        System.out.println(findKthLargestQuickSelect(arr, k));
        System.out.println(findKthLargestHeap(arr, k));

        //median using quickselect

        arr = new int[]{7, 10, 4, 3, 20, 15, 16, 17, 22, 23};
        System.out.println(Arrays.toString(arr));
        if(arr.length % 2 != 0) {
            System.out.println("Median " + findKthLargestQuickSelect(arr, arr.length / 2 + 1));
        } else {
            System.out.println("Median " + (findKthLargestQuickSelect(arr, arr.length / 2 + 1) +
                                findKthLargestQuickSelect(arr, arr.length / 2)) / 2.0);
        }
    }

    // o(nlogn)
    private static int findKthLargestSort(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-k];
    }

    // o(n) best case, o(n2) worst case
    // In QuickSort, we pick a pivot element, then move the pivot element to its correct
    // position and partition the array around it. The idea is, not to do complete quicksort,
    // but stop at the point where pivot itself is k’th smallest element. Also, not to recur
    // for both left and right sides of pivot, but recur for one of them according to the position of pivot.
    private static int findKthLargestQuickSelect(int[] arr, int k){
        if(k<1 || arr == null){
            return 0;
        }
        return getKth(arr.length-k+1, arr, 0, arr.length-1);
    }

    private static int getKth(int k, int[] arr, int start, int end) {
        int pivot = arr[end];
        int left = start;
        int right = end;

        while(true){
            while(arr[left] < pivot && left < right){
                left++;
            }

            while(arr[right] >= pivot && left < right){
                right--;
            }

            if(left == right) break;

            swap(arr, left, right);
        }

        swap(arr, left, end);
        if(k == left+1){
            return pivot;
        } else if(k < left+1){
            return getKth(k, arr, start, left-1);
        } else {
            return getKth(k, arr, left+1, end);
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    // o(nlogk) time, o(k) space
    private static int findKthLargestHeap(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i: arr){
            heap.offer(i);

            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }


//    static class maxHeapComparator implements Comparator<Integer> {
//        @Override
//        public int compare (Integer x, Integer y) {
//            return x-y; //reverse order
//        }
//    }
}
