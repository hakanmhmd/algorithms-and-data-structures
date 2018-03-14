package Math;

/**
 * Created by hakanmehmed on 13/03/2018.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(123, 5));
    }

    public static int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        int sign = 1;
        if(dividend < 0 && divisor < 0) sign = 1;
        else if(dividend < 0 || divisor < 0) sign = -1;

        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        long temp = 0;
        long q = 0;


        for(int i=31; i>=0; i--){
            if (temp + (pDivisor << i) <= pDividend) {
                temp += pDivisor << i;
                q |= 1 << i;
            }
        }

        return (int)q * sign;
    }
}
