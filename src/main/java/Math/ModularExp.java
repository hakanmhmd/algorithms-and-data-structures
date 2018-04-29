package Math;

/**
 * Given three numbers x, y and p, compute (xy) % p.
 */
public class ModularExp {
    public static void main(String[] args) {
        int x = 22342;
        int y = 313;
        int p = 5234;

        System.out.println(calc(x,y,p));
    }

    private static int calc(int x, int y, int p) {
        int res = 1;
        x = x % p;
        while(y>0){
            // exponent is odd
            if((y&1)==1){
                res = (res*x) % p;
            }

            // should be even now - y/2
            y = y >> 1;
            x = (x*x) % p;
        }
        return res;
    }
}
