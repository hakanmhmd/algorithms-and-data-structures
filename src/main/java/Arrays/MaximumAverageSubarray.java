package Arrays;

/**
 * Given an array consisting of n integers, find the contiguous subarray whose length is greater than or
 * equal to k that has the maximum average value. And you need to output the maximum average value.
 */
public class MaximumAverageSubarray {
    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println(maxAvg(arr, k));
    }

    private static double maxAvg(int[] arr, int k) {
        double maxAvg = Double.MIN_VALUE;
        for(int len=k; len<=arr.length; len++){
            int start = 0;
            int end = 0;
            double avg = 0.0;
            while(end < arr.length){
                if(end - start == len){
                    maxAvg = Math.max(maxAvg, avg);
                    avg -= (double) arr[start] / len;
                    start++;

                }
                avg += (double) arr[end] / len;
                end++;
            }
        }

        return maxAvg;
    }
}
