package Math;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.hackerrank.com/contests/world-codesprint-12/challenges/breaking-sticks/problem
 * Fast prime factorization of a number
 */
public class BreakingSticks {

    static long longestSequence(long[] a) {
        //  Return the length of the longest possible sequence of moves.
        long sum = 0;
        for(long stick: a){
            if(stick == 1){
                sum += 1;
                continue;
            }

            ArrayList<Long> primes = primeFactors(stick);
            Collections.sort(primes, Collections.reverseOrder());
            long temp = 0;
            while(primes.size() != 1){
                temp += product(primes);
                primes.remove(primes.size()-1);
            }
            temp += primes.get(0);
            temp += 1;
            sum += temp;
        }

        return sum;
    }

    private static long product(ArrayList<Long> nums){
        long p = 1;
        for(long num: nums){
            p *= num;
        }
        return p;
    }

    private static ArrayList<Long> primeFactors(long num){
        ArrayList<Long> primeFactors = new ArrayList<>();
        long n = num;

        for(long i=2; i<=n/i; i++){
            while(n % i == 0){
                primeFactors.add(i);
                n /= i;
            }
        }
        if(n>1) primeFactors.add(n);

        return primeFactors;
    }

    public static void main(String[] args) {

        long result = longestSequence(new long[] {1, 7, 24});
        System.out.println(result);
    }
}
