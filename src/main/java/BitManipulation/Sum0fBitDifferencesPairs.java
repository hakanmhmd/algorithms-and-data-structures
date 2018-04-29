package BitManipulation;

/**
 * Given an integer array of n integers, find sum of bit differences in all pairs that can be formed from array elements.
 * Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x and y.
 * For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 ( first and last bits
 * differ in two numbers).
 */
public class Sum0fBitDifferencesPairs {
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        System.out.println(sumOfDifferences(arr));
    }

    // Brute force - go through all pairs O(N^2)

    // O(N) solution uses the fact that intergers are 32 bits or any set number of bits
    private static final int BIT_COUNT = 32;
    private static int sumOfDifferences(int[] arr) {
        int count = 0;
        for(int i=0; i<BIT_COUNT; i++){
            int ithCount = 0;
            for(int j=0; j<arr.length; j++){
                int num = arr[j];
                ithCount += num & 1;
                arr[j] = num >>> 1;
            }
            if(ithCount != 0 && ithCount != arr.length){
                count += arr.length - ithCount;
            }
        }
        return count*2;
    }
}
