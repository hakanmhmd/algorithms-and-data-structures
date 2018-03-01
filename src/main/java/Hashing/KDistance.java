package Hashing;

import java.util.HashSet;

/**
 * Given an unsorted array that may contain duplicates. Also given a number k which is smaller
 * than size of array. Write a function that returns true if array contains duplicates within k distance.
 */
public class KDistance {

    public static void main (String[] args)
    {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        if (checkDuplicatesWithinK(arr, 3))
            System.out.println("Yes");
        else
            System.out.println("No");

        removeDiplicatesWithinK(arr, 3);
    }

    private static void removeDiplicatesWithinK(int[] arr, int k) {
        int[] withoutDips = new int[arr.length];
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i])){
                withoutDips[index++] = arr[i];
            }

            set.add(arr[i]);
            if(i >= k){
                set.remove(arr[i-k]);
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.print(withoutDips[i] + " ");
        }
    }

    private static boolean checkDuplicatesWithinK(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                return true;
            } else {
                set.add(arr[i]);
                if(i >= k){
                    set.remove(arr[i-k]);
                }
            }
        }
        return false;
    }
}
