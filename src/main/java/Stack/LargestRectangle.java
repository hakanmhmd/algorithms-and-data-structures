package Stack;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 */
public class LargestRectangle {
    static long largestRectangle(int[] h, int minH, int maxH) {
        long max = maxH;
        if(minH * h.length > max) max = minH * h.length;

        int[] w = new int[h.length];
        for(int i=0; i<h.length; i++){
            w[i] = findWidth(i, h);
        }

        for(int i=0; i<h.length; i++){
            long prod = h[i] * w[i];
            if(max < prod) max = prod;
        }

        return max;
    }

    static int findWidth(int i, int[] h){
        int width = 1;
        int temp = i;
        temp--;
        while(temp >= 0){
            if(h[temp] < h[i]) break;
            width++;
            temp--;
        }

        temp = i;
        temp++;
        while(temp < h.length){
            if(h[temp] < h[i]) break;
            width++;
            temp++;
        }

        return width;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;
        for(int h_i = 0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
            if(minH > h[h_i]){
                minH = h[h_i];
            }
            if(maxH < h[h_i]){
                maxH = h[h_i];
            }
        }
        long result = largestRectangle(h, minH, maxH);
        System.out.println(result);
        in.close();
    }
}
