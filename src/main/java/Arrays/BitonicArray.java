package Arrays;

/**
 * Given a bitonic sequence of n distinct elements, write a program to find a given element x in the bitonic
 * sequence in O(log n) time. A Bitonic Sequence is a sequence of numbers which is first strictly
 * increasing then after a point strictly decreasing.
 */
public class BitonicArray {
    public static void main(String[] args) {
        int arr[] = {-3, 9, 8, 20, 18, 17, 5, 1};
        int target = 18;
        int x = findTarget(arr, target);
        System.out.println(x);
    }

    private static int findTarget(int[] arr, int target) {
        int k = findBitonicPoint(arr); // this is the max element in the arr
        if(arr[k] == target) return k;
        else if(arr[k] > target){
            int temp = ascendingBinarySearch(arr, 0, k-1, target);
            if (temp != -1)
                return temp;

            return descendingBinarySearch(arr, k+1, arr.length-1, target);
        } else {
            return -1;
        }
    }

    private static int descendingBinarySearch(int[] arr, int left, int right, int target) {
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    private static int ascendingBinarySearch(int[] arr, int left, int right, int target) {
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    private static int findBitonicPoint(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            if(left == right){
                return left;
            }
            if(right == left+1){
                return arr[left] > arr[right] ? left : right;
            }

            int mid = (left + right) / 2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            } else if(arr[mid] < arr[mid+1] && arr[mid] > arr[mid-1]){
                left = mid+1;
            } else if (arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]){
                right = mid-1;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
