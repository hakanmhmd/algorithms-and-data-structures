package Sorting;

import java.util.Random;

/**
 * Some sorting algos
 */
public class Sorting {
    public void insertionSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;

            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }

            a[i + 1] = key;
        }
    }

    public void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++)
            swap(a, i, min(a, i));
    }

    private int min(int[] a, int start) {
        int smallest = start;

        for (int i = start + 1; i < a.length; i++)
            if (a[i] < a[smallest])
                smallest = i;

        return smallest;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int pivot = partition(a, low, high);
        quickSort(a, low, pivot - 1);
        quickSort(a, pivot + 1, high);
    }

    private int partition(int[] a, int low, int high) {
        int pivot = low;
        int rand = new Random().nextInt(high - low + 1) + low;
        swap(a, low, rand);

        for (int i = low + 1; i <= high; i++) {
            if (a[i] < a[pivot]) {
                swap(a, i, pivot + 1);
                swap(a, pivot, pivot + 1);
                pivot++;
            }
        }

        return pivot;
    }

    public void heapSort(int[] a) {
        // build a max-heap
        for (int i = a.length - 1; i >= 0; i--)
            heapify(a, i, a.length);

        // extract max element from the head to the end and shrink the size of the heap
        for (int last = a.length - 1; last >= 0; last--) {
            swap(a, 0, last);
            heapify(a, 0, last);
        }
    }

    // heapify for a max-heap:
    private void heapify(int[] a, int root, int length) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int largest = root;

        if (left < length && a[largest] < a[left])
            largest = left;

        if (right < length && a[largest] < a[right])
            largest = right;

        if (largest != root) {
            swap(a, root, largest);
            heapify(a, largest, length);
        }
    }

    public int[] countingSort(int[] a) {
        int max = findMax(a);
        int[] sorted = new int[a.length];
        int[] counts = new int[max + 1];

        for (int i = 0; i < a.length; i++)
            counts[a[i]]++;

        for (int i = 1; i < counts.length; i++)
            counts[i] += counts[i - 1];

        for (int i = 0; i < a.length; i++) {
            sorted[counts[a[i]] - 1] = a[i];
            counts[a[i]]--;
        }

        return sorted;
    }

    private int findMax(int[] a) {
        if (a.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }
}
