package Strings;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1234;
        System.out.println(reverseNumber(num));
    }

    private static int reverseNumber(int x){
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = x * -1;
        }
        int result = 0;
        int n =x;
        while(n != 0){
            int rem = n % 10;
            int reversedNumber = result * 10 + rem;
            // out of bounds ?
            if ((reversedNumber - rem) / 10 != result){
                return 0;
            }
            result = reversedNumber;
            n = n / 10;

        }

        if(negative) return (int) result * -1;
        else return (int) result;
    }
}
