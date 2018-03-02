package Sorting;

import java.util.Arrays;

/**
 * Created by hakanmehmed on 02/03/2018.
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        mergesort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergesort(int[] arr, int left, int right) {
        if(left < right){
            int mid = left + (right - left) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[arr.length];
        for (int i = left; i <= right; i++) {
            helper[i] = arr[i];
        }

        int i = left;
        int j = mid+1;

        int k = left;

        while(i<=mid && j<=right){
            if(helper[i] <= helper[j]){
                arr[k] = helper[i];
                i++;
            } else {
                arr[k] = helper[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            arr[k] = helper[i];
            i++;
            k++;
        }

        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.
    }
}
