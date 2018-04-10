package BitManipulation;

/**
 * Toggle all the bits to the right of the most significant bit (MSB including)
 */
public class ToggleBits {
    public static void main(String[] args) {
        int n = 50; //110010 -> 1101
        System.out.println(toggleBits(n));
    }

    private static int toggleBits(int n) {
        if(n == 0) return 1;

        int nextSetBit = 1;
        int solution = 0;
        while(n != 0){
            int bit = n & 1; // LSB
            if(bit == 0){
                solution |= nextSetBit;
            }
            nextSetBit <<= 1;
            n >>>= 1; // unsigned right shift
        }

        return solution;
    }
}
