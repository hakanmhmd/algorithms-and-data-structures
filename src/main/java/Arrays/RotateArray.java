package Arrays;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(arr));
        bubbleRotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    // O(N) time and space
    private static void rotate(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        if (k > arr.length) {
            k = k % arr.length;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < k; i++) {
            res[i] = arr[arr.length - k + i];
        }

        int j = 0;
        for (int i = k; i < res.length; i++) {
            res[i] = arr[j];
            j++;
        }

        System.arraycopy(res, 0, arr, 0, res.length);
    }

    // O(N) time and O(1) space - divide array in two parts (0, len-k) , (len-k+1, len)
    private static void rotate2(int arr[], int k) {
        if (arr == null || arr.length == 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        if (k > arr.length) {
            k = k % arr.length;
        }

        int divide = arr.length - k;

        reverse(arr, 0, divide - 1);
        reverse(arr, divide, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    //O(n*k) time and O(1) space
    private static void bubbleRotate(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0) {
            throw new IllegalArgumentException();
        }
        if (k > arr.length) {
            k = k % arr.length;
        }

        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        if (arr == null || arr.length == 1)
            return;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*
     rotate left

     static int[] leftRotation(int[] a, int d) {
        d = d % a.length;
        reverse(a, 0, d-1);
        reverse(a, d, a.length-1);
        reverse(a, 0, a.length-1);
        return a;
    }

    static void reverse(int[] arr, int s, int e){
        if(arr==null || arr.length == 0 || arr.length == 1){
            return;
        }
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
     */


}
