package DynamicProgramming;

/**
 * Created by hakanmehmed on 14/11/2017.
 */
public class MagixIndex {
    public static void main(String[] args) {
        int[] arr = {-40, -20, -1, 1, 2, 3, 5 ,7, 9, 12 ,14};
        System.out.println(findMagicIndex(arr));

        int[] arr2 = {-40, -5, 2, 2, 2, 3, 4 ,7, 9, 12 ,13};
        System.out.println(findMagicIndex(arr2));
    }

    private static int findMagicIndex(int[] arr) {
        return findMagicIndexNotDistinct(arr, 0, arr.length-1);
    }

    private static int findMagicIndexDistinct(int[] arr, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end)/2;
        if(arr[mid] == mid){
            return mid;
        }
        else if (arr[mid] < mid){
            return findMagicIndexDistinct(arr, mid+1, end);
        } else {
            return findMagicIndexDistinct(arr, start, mid-1);
        }
    }

    private static int findMagicIndexNotDistinct(int[] arr, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end)/2;
        if(arr[mid] == mid){
            return mid;
        }

        // check left part
        int leftIndex = Math.min(mid-1, arr[mid]);
        int left = findMagicIndexNotDistinct(arr, start, leftIndex);
        if(left >= 0) return left;
        // check right part
        int rightIndex = Math.max(mid+1, arr[mid]);
        int right = findMagicIndexNotDistinct(arr, rightIndex, end);
        return right;
    }
}
