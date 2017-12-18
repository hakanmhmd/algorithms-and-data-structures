package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 * You are given a list(1-indexed) of size n, initialized with zeroes. You have to perform m operations
 * on the list and output the maximum of final values of all the n elements in the list.
 * For every operation, you are given three integers a, b and k and you have to add value k to all
 * the elements ranging from index  to (both inclusive).


 */
public class ArrayManipulation {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        long[] arr = new long[n+1];
        Arrays.fill(arr, 0);

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            arr[a-1] += k;
            arr[b] -= k;
        }
        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}

/*
    5 3
    1 2 100
    2 5 100
    3 4 100

    0      1      2     3      4
    100    100    0     0   -100
 */
