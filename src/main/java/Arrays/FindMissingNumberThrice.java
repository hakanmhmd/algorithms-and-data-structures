package Arrays;

/**
 * Given a contiguous sequence of numbers in which each number repeats thrice, there is exactly
 * one missing number. Find the missing number.
 eg: 11122333 : Missing number 2
 11122233344455666 Missing number 5
 */
public class FindMissingNumberThrice {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3};
        System.out.println(findMissing(arr));
        arr = new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5,5,6,6,6};
        System.out.println(findMissing(arr));
    }

    private static int findMissing(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;

        while(lo < hi){
            int mid = (lo+hi) / 2;
            // only two elements left
            if(hi-lo+1 < 3) break;

            while(mid+1 <= hi && arr[mid] == arr[mid+1]) mid++;

            // Recurse on half that doesn't have 3 * number of elements:
            if((mid-lo+1) % 3 == 0){
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        return arr[lo];
    }
}
