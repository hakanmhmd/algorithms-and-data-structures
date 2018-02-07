package Math;

/**
 * Sieve of Eratosthenes
 */
public class PrimeSieve {
    public static void main(String[] args) {
        int n = 30;
        System.out.print("Following are the prime numbers ");
        System.out.println("smaller than or equal to " + n);
        sieveOfEratosthenes(n);
    }

    private static void sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n+1];

        for(int i = 2;i <= n;i++)
            prime[i] = true;

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
           if(prime[i]){
               for(int j=i*2; j <= n; j+=i){
                   prime[j] = false;
               }
           }

        }

        for (int i = 0; i <= n; i++) {
            if(prime[i]){
                System.out.print(i + " ");
            }

        }

    }
}
