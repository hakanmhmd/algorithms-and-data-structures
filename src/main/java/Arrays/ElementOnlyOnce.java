package Arrays;

/**
 * Given an array where every element occurs three times, except one element which occurs only once.
 * Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
 *
 * We can sum the bits in same positions for all the numbers and take modulo with 3.
 * The bits for which sum is not multiple of 3, are the bits of number with single occurrence.
 */
public class ElementOnlyOnce {
    final static int INT_SIZE = 32;

    public static void main(String args[])
    {
        int arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
        int n = arr.length;


        System.out.println("The element with single occurrence is " + findSingle(arr, n));
    }

    private static int findSingle(int[] arr, int n) {
        int result = 0;
        int x;
        int sum;

        for(int i=0; i<INT_SIZE; i++) {
            sum = 0;
            x = (1 << i);

            for(int j=0; j<n; j++){
                if((arr[j] & x) == 0){
                    sum++;
                }
            }

            if(sum % 3 == 0){
                result |= x;
            }
        }

        return result;
    }


}
