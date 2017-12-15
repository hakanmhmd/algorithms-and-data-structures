package Arrays;

/**
 * Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times.
 * Find the number in O(n) time & constant space.
 *
 * XOR table:
 *  x ^ x = 0 - if two elements are the same their xor is zero
 *  x ^ 0 = x - element xored by 0 gives the element
 *
 *  => x^x^x = x (or any odd times)
 */
public class OddOccurance {
    private int[] elements;
    public OddOccurance(int[] arr){
        this.elements = arr;
    }
    
    public int findOddOccurance(){
        int result = 0;
        for (int i = 0; i < elements.length; i++) {
            int element = elements[i];
            //bitwise XOR
            // even occurances will become 0
            // odd occurance will return the number
            result ^= element;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int ar[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2, 5};
        OddOccurance oo = new OddOccurance(ar);
        System.out.println(oo.findOddOccurance());
    }
}
