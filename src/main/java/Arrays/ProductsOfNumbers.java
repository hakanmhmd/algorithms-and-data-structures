package Arrays;

import java.util.Arrays;

/**
 * Given an array of numbers, return an array of numbers products, where products[i] is the product of all nums[j], j != i.
 */
public class ProductsOfNumbers {

    public static void main(String[] args) {
        int[] a  = new int[]{1,2,3,4};
        int[] products_below = new int[a.length];
        int p=1;
        for(int i=0;i<a.length;++i) {
            products_below[i]=p;
            p*=a[i];
        }

        System.out.println(Arrays.toString(products_below));

        int[] products_above = new int[a.length];
        p=1;
        for(int i=a.length-1;i>=0;--i) {
            products_above[i]=p;
            p*=a[i];
        }

        System.out.println(Arrays.toString(products_above));

        int[] products = new int[a.length]; // This is the result
        for(int i=0;i<a.length; ++i) {
            products[i]=products_below[i]*products_above[i];
        }

        System.out.println(Arrays.toString(products));
    }
}
