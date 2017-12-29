package BitManipulation;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor/problem
 * Find the most significant bit that is different and that we change without violating the constraints
 * X <= A <= B <= Y
 * After this bit all the bits to its right can be flipped to be different.
 */
public class MaximizingXOR {
    public static void main(String[] args) {
        int x = 23;
        int y = 28;


        System.out.println(findMaxXOR(x, y));
    }

    private static int findMaxXOR(int x, int y) {
        int xored  = x ^ y;
        int significantBit = 32 - Integer.numberOfLeadingZeros(xored);
        return (1 << (significantBit)) - 1;
    }


}
