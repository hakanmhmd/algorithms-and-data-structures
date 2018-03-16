package BitManipulation;

/**
 * Given a positive integer, check whether it has alternating bits: namely,
 * if two adjacent bits will always have different values.
 */
public class AlternatingBits {
    public static void main(String[] args) {
        int n = 5; //101
        System.out.println(hasAlternatingBits(n));
    }

    public static boolean hasAlternatingBits(int n) {
        int prevBit = -1;
        while (n > 0){
            int currentBit = n & 1;
            if(prevBit != -1 && currentBit == prevBit){
                return false;
            }
            prevBit = currentBit;
            n = n >> 1;
        }

        return true;
    }
}
