package Arrays;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));
        arr = new int[]{4,4,5,7,2};
        System.out.println(findMinDuplicate(arr));
    }
    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length-1;

        while(left < right){

            int mid = left + (right-left)/2;
            if(nums[mid] >= nums[right]){
                left = mid+1;
            } else {
                right = mid;
            }

        }
        return nums[left];
    }

    public static int findMinDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length-1;

        while(left < right){

            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }

        }
        return nums[left];
    }
}
