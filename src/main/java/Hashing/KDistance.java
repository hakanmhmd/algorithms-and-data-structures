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
    }

    private static boolean checkDuplicatesWithinK(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
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
