package Arrays;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1]. For example, given [5, 7, 7, 8, 8, 10]
 * and target value 8, return [3, 4].
 */
public class SearchInRange {
    public static void main(String[] args) {
        int[] input = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        int[] range = findRange(input, target);
        System.out.println(Arrays.toString(range));
        System.out.println(Arrays.toString(searchRangeIter(input, target)));
    }

    public static int[] searchRangeIter(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] res = {-1, -1};

        while(left <= right){
            if(nums[left] == nums[right] && nums[left] == target){
                res[0] = left;
                res[1] = right;
                return res;
            }

            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                res[0] = mid;
                res[1] = mid;
                int index = mid;

                while(index > left && nums[index] == nums[index-1]){
                    index--;
                    res[0] = index;
                }
                index = mid;
                while(index < right && nums[index] == nums[index+1]){
                    index++;
                    res[1] = index;
                }
                return res;
            } else if(nums[mid] > target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return res;
    }

    private static int[] findRange(int[] input, int target) {
        if(input==null || input.length==0) return null;
        int[] arr = new int[2];
        Arrays.fill(arr, -1);

        binarySearch(input, 0, input.length-1, target, arr);
        return arr;
    }

    private static void binarySearch(int[] input, int left, int right, int target, int[] arr) {
        if(left > right) return;

        if(input[left] == input[right] && input[left] == target){
            arr[0] = left;
            arr[1] = right;
            return;
        }

        int mid = (left + right) / 2;
        if(input[mid] == target){
            arr[0] = mid;
            arr[1] = mid;
            int temp = mid;

            while(temp > left && input[temp] == input[temp-1]){
                temp--;
                arr[0] = temp;
            }
            temp = mid;
            while(temp < right && input[temp] == input[temp+1]){
                temp++;
                arr[1] = temp;
            }

        } else if(input[mid] > target) {
            binarySearch(input, left, mid-1, target, arr);
        } else {
            binarySearch(input, mid+1, right, target, arr);
        }
    }
}
