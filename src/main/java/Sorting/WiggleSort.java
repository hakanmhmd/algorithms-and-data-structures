package Sorting;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,6,4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        boolean less = true;

        for(int i=0; i<arr.length-1; i++){
            if(less){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            } else {
                if(arr[i] < arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
            less = !less;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
