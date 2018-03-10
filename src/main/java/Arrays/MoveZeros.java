package Arrays;

import java.util.Arrays;

/**
 * Move zeros to the end of the array (in-place)
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4,0,0,5,0,0,0,10};

        shiftZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shiftZeros(int[] arr) {
        int j=0;
        for(int i=0;i<arr.length; i++){
            if(arr[i] != 0){
                //move arr[i] to arr[j]
                swap(arr, i, j);
                System.out.println(Arrays.toString(arr));
                j++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
