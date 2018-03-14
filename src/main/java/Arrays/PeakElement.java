package Arrays;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 *
 * if element is not peak -> x is smaller then at least one of its neighbours
 *    1) left neighbour > x => we can always find peak on the left of x
 *    2) right neighbout > x => we can always find peak on the right of x
 *
 * visualize with a graph for better understanding
 */
public class PeakElement {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 1};
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;

        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))){
                return mid;
            }
            else{
                if(mid != 0 && nums[mid-1] > nums[mid]){
                    right = mid-1;
                } else if(nums[mid+1] > nums[mid]){
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}
