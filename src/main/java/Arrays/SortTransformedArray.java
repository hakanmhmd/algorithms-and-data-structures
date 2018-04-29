package Arrays;

import java.util.Arrays;

/**
 * Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of
 * the form f(x) = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)
 */
public class SortTransformedArray {
    public static void main(String[] args) {
        int[] arr = {-4, -2, 2, 4};
        int a = -1, b = 3, c = 5;

        System.out.println(Arrays.toString(sort(arr, a, b, c)));
    }

    private static int[] sort(int[] arr, int a, int b, int c) {
        int start = 0;
        int end = arr.length-1;
        int[] res = new int[arr.length];
        int k1 = 0, k2 = arr.length-1;
        while(start <= end){
            int first = calculate(arr[start], a, b, c);
            int second = calculate(arr[end], a, b, c);
            if(a >= 0){
                if(first > second){
                    res[k2--] = first;
                    start++;
                } else {
                    res[k2--] = second;
                    end--;
                }
            } else {
                if(first < second){
                    res[k1++] = first;
                    start++;
                } else {
                    res[k1++] = second;
                    end--;
                }
            }
        }

        return res;
    }

    private static int calculate(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
