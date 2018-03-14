package Arrays;

import java.util.Arrays;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class ReverseBytes {
    public static void main(String[] args) {
        byte[] arr = new byte[]{5, 6, 1};
        System.out.println(Arrays.toString(reverse(arr)));
    }

    public static byte[] reverse(byte[] bytes) {
        int n = bytes.length;
        for (int i = 0; i < bytes.length / 2; i++) {
            swap(bytes, i, n-i-1);
        }

        System.out.println(Arrays.toString(bytes));

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = reverseBitsByte(bytes[i]);
        }

        return bytes;
    }

    public static byte reverseBitsByte(byte x) {
        byte res = 0;
        for(int i = 0; i < 8; i++) {
            res <<= 1;
            res |= x & 1;
            x >>= 1;
        }
        return res;
    }

    private static void swap(byte[] arr, int i, int j){
        byte temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
