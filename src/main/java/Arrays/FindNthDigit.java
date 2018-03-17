package Arrays;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 */
public class FindNthDigit {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(findNthDigit(n));
    }

    public static int findNthDigit(int n) {
        long m = (long)n;
        long start = 1;
        long digits = 9;
        long len = 1;

        while(m > len*digits){
            m -= len*digits;
            digits *= 10;
            len++;
            start*=10;
        }

        long num = start + (m-1)/len;
        long digit = (m-1) % len;

        return String.valueOf(num).charAt((int)digit) - '0';

    }
}
