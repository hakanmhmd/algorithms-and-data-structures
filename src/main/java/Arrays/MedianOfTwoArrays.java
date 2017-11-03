package Arrays;

import java.util.Arrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 12, 15, 26, 38, 40, 43, 55};
        int arr2[] = {2, 13, 17, 30, 45};

        int n1 = arr1.length;
        int n2 = arr2.length;
        System.out.println("Median is " +
                    getMedian(arr1, arr2, n1, n2));
    }

    // O(arr1.length + arr2.length)
    private static String getMedian(int[] arr1, int[] arr2, int n1, int n2) {
        int i=0;
        int j=0;
        int k=0;
        int[] result = new int[n1+n2];
        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while(i<n1){
            result[k++] = arr1[i++];
        }
        while(j<n2){
            result[k++] = arr2[j++];
        }

        int n3 = result.length;
        System.out.println(Arrays.toString(result));
        if(n3 % 2 == 0){
            return String.valueOf((result[n3/2-1] + result[n3/2]) / 2.0);
        } else {
            return String.valueOf(result[n3/2]);
        }
    }

    private static double getMedian2(int[] arr1, int[] arr2, int n1, int n2){
        int total = n1+n2;
        if(total%2==0){
            return (findKth(total/2+1, arr1, arr2, 0, 0) + findKth(total/2, arr1, arr2, 0, 0)) / 2.0;
        } else {
            return findKth(total/2, arr1, arr2, 0, 0);
        }
    }

    private static int findKth(int k, int[] arr1, int[] arr2, int s1, int s2) {
        if(s1>=arr1.length){
            return arr2[s2+k-1];
        }
        if(s2>=arr2.length){
            return arr1[s1+k-1];
        }
        if(k==1){
            return Math.min(arr1[s1], arr2[s2]);
        }
        int m1 = s1+k/2-1;
        int m2 = s2+k/2-1;
        int mid1 = m1<arr1.length?arr1[m1]:Integer.MAX_VALUE;
        int mid2 = m2<arr2.length?arr2[m2]:Integer.MAX_VALUE;

        if(mid1 < mid2){
            return findKth(k-k/2, arr1, arr2, m1+1, s2);
        } else {
            return findKth(k-k/2, arr1, arr2, s1, m2+1);
        }
    }
}
