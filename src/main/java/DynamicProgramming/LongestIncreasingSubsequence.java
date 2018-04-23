package DynamicProgramming;

import java.util.Arrays;

/**
 * Given an array of random numbers. Find longest increasing subsequence (LIS) in the array
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 0, 6, 2, 3}; //-1,0,2,3
        int[] input = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        int m = findLIS(arr);
        System.out.println(m);
        int n = findLIS2(input);
        System.out.println(n);

        System.out.println(findLIS3(arr));
    }


    // same as findLIS2 but with the actual subsequence
    public static int findLIS3(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return 1;

        int[] parent = new int[arr.length];
        int[] subseq = new int[arr.length+1];
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            // find a place for arr[i] in subseq array
            int low = 1;
            int high = len;
            while(low <= high){
                int mid = (int) Math.ceil((low+high) / 2);
                if(arr[i] > arr[subseq[mid]]){
                    low = mid + 1;
                } else {
                    high = mid-1;
                }
            }

            int pos = low;
            parent[i] = subseq[pos-1];
            subseq[pos] = i;

            if(pos > len) len = pos;

        }

        int[] lis = new int[len];
        int k = subseq[len];
        for(int j=len-1; j>=0; j--){
            lis[j] = arr[k];
            k = parent[k];
        }

        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(subseq));
        System.out.println(Arrays.toString(parent));
        return len;
    }


    // O(nlogn)
    public static int findLIS2(int[] arr) {
        int[] temp = new int[arr.length];
        int[] result = new int[arr.length];

        Arrays.fill(result, -1);
        temp[0] = 0;
        int len = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[temp[len]]){
                len++;
                temp[len] = i;
                result[temp[len]] = temp[len-1];
            } else if(arr[i] < arr[temp[0]]){
                temp[0] = i;
            } else { //do binary search to find ceiling for arr[i]
                int index = findCeil(arr, temp, len,arr[i]);
                temp[index] = i;
                result[temp[index]] = temp[index-1];
            }
        }
        int index = temp[len];
        while(index != -1) {
            System.out.print(arr[index] + " ");
            index = result[index];
        }

        System.out.println();
        return len+1;
    }

    private static int findCeil(int[] arr, int[] temp, int len, int i) {
        int left = 0;
        int right = len;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(arr[temp[mid]] < i && i <= arr[temp[mid+1]]){
                return mid+1;
            } else if(arr[temp[mid]] < i){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }

        return -1;
    }


    // O(n^2) solution
    // works when there are duplicate elements in the array
    public static int findLIS(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        if(arr.length == 1) return 1;

        int[] lis = new int[arr.length];

        // each element has lis of 1
        Arrays.fill(lis, 1);

        // for each i calc the length of increasing subs ending at i
        for (int i = 1; i < lis.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] >= arr[j]){ // we have an increasing subsequence
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lis.length; i++) {
            max = Math.max(max, lis[i]);
        }
        return max;

    }
}
