package Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SortedRotatedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6, 7};
        int target = 11;
        System.out.println(search(nums, target));
        System.out.println(find(nums, target));
    }

    //pivot element
    private static int find(int[] nums, int target){
        int pivotIndex = findPivot(nums);
        int pivot = nums[pivotIndex];
        if(target == pivot) return pivotIndex;
        else if(target > pivot && target <= nums[nums.length-1]){
            return bSearch(nums, target, pivotIndex+1, nums.length-1);
        } else {
            return bSearch(nums, target, 0, pivotIndex-1);
        }
    }

    private static int bSearch(int[] nums, int target, int left, int right) {
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }


    private static int findPivot(int[] nums) {
        if(nums[0] <= nums[nums.length-1]) return 0; //not rotated
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(mid < nums.length-1 && nums[mid] > nums[mid+1]) return mid+1;
            else if(nums[left] <= nums[mid]){ // start to mid is sorted
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return 0; // its not rotated
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

        if(nums[mid] >= nums[start]){ // start to mid is sorted
            if(nums[start] <= target && target < nums[mid]){ // is target between start and mid
                return binarySearch(nums, start, mid-1, target);
            } else {
                return binarySearch(nums, mid+1, end, target);
            }
        } else { // mid to end it sorted
            if(nums[mid] < target && target <= nums[end]){ // is target between min and end
                return binarySearch(nums, mid+1, end, target);
            } else {
                return binarySearch(nums, start, mid-1, target);
            }
        }
    }
}
