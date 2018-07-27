package Arrays;

import java.util.Arrays;

/**
 * You are given an unsorted array with both positive and negative elements. You have to find the
 * smallest positive number missing from the array in O(n) time using constant extra space.
 * You can modify the original array.
 *
 * Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 * Output: 1
 */
public class SmallestPositiveNumberMissing {
    public static void main(String[] args) {
        int[] input = {1, 1, 0, -1, -2};
        System.out.println(minPositiveElement(input));
    }

    private static int minPositiveElement(int[] input){
        int startPos = moveNonpositiveToFront(input);
        for(int i=startPos; i<input.length; i++){
            int index = Math.abs(input[i])-1;
            if(index+startPos < input.length && input[index+startPos] > 0)
                input[index+startPos] = -input[index+startPos];
        }

        for(int i=startPos; i<input.length; i++){
            if(input[i] > 0) return i+1-startPos;
        }

        return input.length+1;
    }

    private static int moveNonpositiveToFront(int[] arr) {
        int j = 0, temp = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= 0) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        return j;
    }
}
