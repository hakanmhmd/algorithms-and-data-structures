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

        System.out.println(getMedianBSearch(arr1, arr2));


        //////////////////////////
        int[] x = {1,2,5,11,15};
        int[] y = {3,4,13,17,18};

        System.out.println(getMedianSameLength(x, y, 0, x.length-1, 0, y.length-1));
    }

    // O(log n)
    private static double getMedianBSearch(int[] x, int[] y) {
        if (x.length > y.length) {
            return getMedianBSearch(y, x);
        }
        int xLen = x.length;
        int yLen = y.length;

        int start = 0;
        int end = xLen;

        while (start <= end) {

            int partitionX = (start + end) / 2;
            int partitionY = (xLen + yLen + 1) / 2 - partitionX;

            int maxLeftX;
            if (partitionX == 0) {
                maxLeftX = Integer.MIN_VALUE;
            } else {
                maxLeftX = x[partitionX - 1];
            }
            int maxLeftY;
            if (partitionY == 0) {
                maxLeftY = Integer.MIN_VALUE;
            } else {
                maxLeftY = y[partitionY - 1];
            }

            int minRightX;
            if (partitionX == xLen) {
                minRightX = Integer.MAX_VALUE;
            } else {
                minRightX = x[partitionX];
            }

            int minRightY;
            if (partitionY == yLen) {
                minRightY = Integer.MAX_VALUE;
            } else {
                minRightY = y[partitionY];
            }

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //found the partition
                if ((xLen + yLen) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // move towards the left in X
                end = partitionX - 1;
            } else {
                // move towards the right in X
                start = partitionX + 1;
            }
        }
        return -1; // not sorted
    }

    // O(arr1.length + arr2.length)
    private static String getMedian(int[] arr1, int[] arr2, int n1, int n2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            result[k++] = arr1[i++];
        }
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        int n3 = result.length;
        System.out.println(Arrays.toString(result));
        if (n3 % 2 == 0) {
            return String.valueOf((result[n3 / 2 - 1] + result[n3 / 2]) / 2.0);
        } else {
            return String.valueOf(result[n3 / 2]);
        }
    }

    private static double getMedian2(int[] arr1, int[] arr2, int n1, int n2) {
        int total = n1 + n2;
        if (total % 2 == 0) {
            return (findKth(total / 2 + 1, arr1, arr2, 0, 0) + findKth(total / 2, arr1, arr2, 0, 0)) / 2.0;
        } else {
            return findKth(total / 2, arr1, arr2, 0, 0);
        }
    }

    private static int findKth(int k, int[] arr1, int[] arr2, int s1, int s2) {
        if (s1 >= arr1.length) {
            return arr2[s2 + k - 1];
        }
        if (s2 >= arr2.length) {
            return arr1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(arr1[s1], arr2[s2]);
        }
        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;
        int mid1 = m1 < arr1.length ? arr1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < arr2.length ? arr2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKth(k - k / 2, arr1, arr2, m1 + 1, s2);
        } else {
            return findKth(k - k / 2, arr1, arr2, s1, m2 + 1);
        }
    }


    // if the sizes of the two arrays is same
    private static double getMedianSameLength(int[] x, int[] y, int startX, int endX, int startY, int endY){
        if(endX - startX == 1 && endY - startY == 1){
            return (1.0 * (Math.max(x[startX], y[startY]) + Math.min(x[endX], y[endY]))) / 2;
        }

        int mx = (startX + endX) / 2;
        int my = (startY + endY) / 2;

        if(x[mx] == y[my]){
            return x[mx];
        }

        if(x[mx] < y[my]){ // eliminate elems less than x[mx] and greater than y[my]
            startX = mx;
            endY = my;
        } else { // eliminate elems greater than x[mx] and less than y[my]
            startY = my;
            endX = mx;
        }

        return getMedianSameLength(x, y, startX, endX, startY, endY);
    }
}
