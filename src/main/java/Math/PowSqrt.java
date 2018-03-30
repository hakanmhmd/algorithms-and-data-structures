package Math;

/**
 * Created by hakanmehmed on 13/03/2018.
 */
public class PowSqrt {
    public static void main(String[] args) {
        System.out.println("Pow 2,10: " + myPow(2, 10));
        System.out.println("Pow 2,10: " + myPow2(2, 10));
        System.out.println("Sqrt 18: " + mySqrt(18));
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x/2+1;
        long ans = -1;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid == x) return (int)mid;
            else if(mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }

        return (int)ans;

    }

    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }

        double temp = myPow(x, n/2);
        if(n % 2 == 0){
            //System.out.println((temp * temp));
            return temp * temp;
        }
        else{
            if(n > 0){
                //System.out.println((temp * temp) + " * " + x);
                return temp * temp * x;
            }
            else{
                //System.out.println((temp * temp) + " / " + x);
                return (temp*temp)/x;
            }
        }
    }

    public static double myPow2(double x, int n){
        double res = 1.0;
        for(int i=n; i!=0; i/=2){
            System.out.print(i);
            if(i%2 != 0){
                res = res * x;
            }
            x = x * x;
            System.out.print(" " + res);
            System.out.println(" " + x);
        }

        return n<0 ? 1.0 / res : res;
    }
}
