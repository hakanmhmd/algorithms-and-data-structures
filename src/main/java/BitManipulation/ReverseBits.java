package BitManipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
public class ReverseBits {
    public static void main(String[] args) {
        int num = 43261596;
        System.out.println(reverseBits(num));
    }

    public static int reverseBits(int n) {
        for(int i=0; i<16; i++){
            n = swapBits(n, i, 32-i-1);
        }

        return n;

    }

    public static int swapBits(int n, int a, int b){
        int i = (n >> a) & 1;
        int j = (n >> b) & 1;
        //System.out.println("Swapping " + i + " " + j);

        n = setBit(n, a, j);
        n = setBit(n, b, i);
        return n;
    }

    public static int setBit(int n, int pos, int val){
        if(val == 1) n |= 1 << pos;
        else n &= ~(1 << pos);

        return n;
    }
}
