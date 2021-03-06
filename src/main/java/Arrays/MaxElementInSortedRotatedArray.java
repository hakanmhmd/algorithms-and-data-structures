package Arrays;

/**
 * Find max element in sorted rotated array
 */
public class MaxElementInSortedRotatedArray {

    public static void main (String[] args)
    {
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The max element is "+ findMax(arr1, 0, n1-1));

        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The max element is "+ findMax(arr2, 0, n2-1));

        int arr3[] =  {1};
        int n3 = arr3.length;
        System.out.println("The max element is "+ findMax(arr3, 0, n3-1));

        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The max element is "+ findMax(arr4, 0, n4-1));

        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The max element is "+ findMax(arr5, 0, n5-1));

        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The max element is "+ findMax(arr6, 0, n1-1));

        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The max element is "+ findMax(arr7, 0, n7-1));

        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The max element is "+ findMax(arr8, 0, n8-1));

        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The max element is "+ findMax(arr9, 0, n9-1));
    }

    private static int findMax(int[] arr, int low, int high) {
        if(low > high) return arr[arr.length-1];

        int mid = (low + high) / 2;
        if(mid < high && arr[mid+1] < arr[mid]){
            return arr[mid];
        }

        if(mid > low && arr[mid-1]>arr[mid]){
            return arr[mid-1];
        }

        if(arr[high] > arr[mid]){
            return findMax(arr, low, mid-1);
        }
        return findMax(arr, mid+1, high);
    }
}
