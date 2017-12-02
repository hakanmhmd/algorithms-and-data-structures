package Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7};
        int target = 8;
        int index = search(nums, target);
        System.out.println(index);
    }

    // binary search
    private static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        if(end < start) {
            return -1;
        }

        int mid = (start + end) / 2;
        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid] >= nums[start]){
            if(nums[start]<=target && target<nums[mid]){ // is target between start and mid
                return binarySearch(nums, start, mid-1, target);
            } else {
                return binarySearch(nums, mid+1, end, target);
            }
        } else {
            if(nums[end]>=target && target>nums[mid]){ // is target between min and end
                return binarySearch(nums, mid+1, end, target);
            } else {
                return binarySearch(nums, start, mid-1, target);
            }
        }
    }
}
