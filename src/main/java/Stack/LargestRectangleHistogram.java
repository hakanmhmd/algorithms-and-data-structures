package Stack;

import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle/problem
 */
public class LargestRectangleHistogram {
    static long largestRectangle(int[] h) {
        Stack<Integer> s = new Stack<>();
        int i=0;
        int largestRectangle = Integer.MIN_VALUE;

        while(i < h.length) {
            if(s.isEmpty() || h[i] >= h[s.peek()]) {
                s.push(i);
                i++;
            } else {
                Integer index = s.pop();
                int area;
                if(s.isEmpty()){
                   area = h[index] * i;
                } else {
                    area = h[index] * (i-1-s.peek());
                }
                if(area > largestRectangle) largestRectangle = area;

            }
        }

        while(!s.isEmpty()){
            Integer index = s.pop();
            int area;
            if(s.isEmpty()){
                area = h[index] * i;
            } else {
                area = h[index] * (i-1-s.peek());
            }
            if(area > largestRectangle) largestRectangle = area;
        }



        return largestRectangle;
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

    static long largestRectangle2(int[] h) {
        long max = 0;
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

    public static void main(String[] args) {

        int[] h = new int[]{1,2,3,4,5,3,5,2};

        long result = largestRectangle(h);
        long result2 = largestRectangle2(h);
        System.out.println(result);
        System.out.println(result2);
    }
}
