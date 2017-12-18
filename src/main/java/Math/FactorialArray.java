package Math;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/contests/world-codesprint-12/challenges/factorial-array/copy-from/1304512922
 */
public class FactorialArray {
    static int exp = (int)Math.pow(10, 9);
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        in.nextLine();
        for(int a0 = 0; a0 < m; a0++){
            String[] ops = in.nextLine().split(" ");
            if(Integer.parseInt(ops[0]) == 1){
                int l = Integer.parseInt(ops[1]);
                int r = Integer.parseInt(ops[2]);
                for(int i=l-1; i<=r-1; i++){
                    A[i] = A[i] + 1;
                }
            } else if(Integer.parseInt(ops[0]) == 2) {
                // modulo op
                int l = Integer.parseInt(ops[1]);
                int r = Integer.parseInt(ops[2]);

                int start = l-1;
                int end = r-1;
                int[] subarray = IntStream.range(start, end+1)
                                     .map(i -> A[i])
                                     .toArray();

                long sum = 0;
                long[] res = factorial_mod_array(subarray);
                for (int i = 0; i < res.length; i++) {
                    sum += res[i];
                }
                sum = sum % exp;
                System.out.println(sum);
            } else {
                int i = Integer.parseInt(ops[1]);
                int v = Integer.parseInt(ops[2]);
                A[i-1] = v;
            }
        }
        in.close();

        //factorial_mod(5);
    }

    private static long[] factorial_mod_array(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        long[] result = new long[arr.length];
        Arrays.fill(result, 0);
        long f = 1;
        for (int i=1; i<=max; i++){
            f = f * i;
            if(f > exp) f = f % exp;
            if(f == 0) break;
            fill(arr, result, i, f);
        }
        return result;
    }

    private static void fill(int[] arr, long[] result, int i, long f) {
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] == i){
                result[j] = f;
            }
        }
    }

    private static long factorial_mod(int n){
        long f = 1;
        for (int i=1; i<n+1; i++){
            f = f * i;
            if(f > exp) f = f % exp;
            if(f == 0) break;
        }
        return f;
    }
}
