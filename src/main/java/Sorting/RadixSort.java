package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Radix Sort takes O(d*(n+b))
 * b is the base for representing numbers, for example, for decimal system, b is 10.
 * if k is the maximum possible value, then d would be O(logb(k))
 * n is the number of values
 */
public class RadixSort {
    public static void main (String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int d = maxNumDigits(arr);

        for (int i = 1; i <= d; i++)
            countingSort(arr, i);
    }

    private static void countingSort(int[] arr, int i) {
        ArrayList[] buckets = new ArrayList[10];
        for(int j=0; j<10; j++){
            buckets[j] = new ArrayList<Integer>();
        }

        for (int j = 0; j < arr.length; j++) {
            int digit = (int) ((arr[j] / Math.pow(10, i - 1)) % 10);
            buckets[digit].add(arr[j]);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (Integer num : bucket) {
                arr[index++] = num;
            }
        }
        System.out.println(Arrays.toString(arr));

    }



    private static int maxNumDigits(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }

        int numDigits = 0;
        while(max != 0){
            numDigits++;
            max = max/10;
        }
        return numDigits;
    }
}
