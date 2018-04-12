package Arrays;

import java.util.Arrays;

/**
 * Given an array of numbers, return an array of numbers products, where products[i] is the product of all nums[j], j != i.
 */
public class ProductsOfNumbers {

    // without division
    // edges cases - zeros, less tham 2 ints
    public static void main(String[] args) {
        int[] a  = new int[]{1,2,3,4};
        int[] products_left = new int[a.length];
        int p=1;
        for(int i=0;i<a.length;++i) {
            products_left[i]=p;
            p*=a[i];
        }

        System.out.println(Arrays.toString(products_left));

        int[] products_right = new int[a.length];
        p=1;
        for(int i=a.length-1;i>=0;--i) {
            products_right[i]=p;
            p*=a[i];
        }

        System.out.println(Arrays.toString(products_right));

        int[] products = new int[a.length];
        for(int i=0;i<a.length; ++i) {
            products[i]=products_left[i]*products_right[i]; // product left of i * product right of i
        }

        System.out.println(Arrays.toString(products));
    }

    // constant space
    public int[] productExceptSelf(int[] nums) throws Exception {
        if(nums.length < 2) throw new Exception();
        int[] result = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
