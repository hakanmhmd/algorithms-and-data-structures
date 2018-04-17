package Arrays;

import java.util.Arrays;

/**
 * Given an array:

 [a_1, a_2, ..., a_N, b_1, b_2, ..., b_N, c_1, c_2, ..., c_N ]

 convert it to:

 [a_1, b_1, c_1, a_2, b_2, c_2, ..., a_N, b_N, c_N]

 in-place using constant extra space.
 */
public class ConvertArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        convertArr(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void convertArr(int[] arr) {
        int N = arr.length/3;
        for(int originalIndex=0; originalIndex<arr.length; originalIndex++){
            int newIndex = getIndex(originalIndex, N);
            while(newIndex < originalIndex){
                newIndex = getIndex(newIndex, N);
            }
            //swap
            int temp = arr[originalIndex];
            arr[originalIndex] = arr[newIndex];
            arr[newIndex] = temp;
        }
    }
    // The element at the ith position in the final array is at position (i%3)*N + i/3 in the original array
    private static int getIndex(int originalIndex, int n) {
        return (originalIndex % 3) * n + originalIndex/3;
    }
}
