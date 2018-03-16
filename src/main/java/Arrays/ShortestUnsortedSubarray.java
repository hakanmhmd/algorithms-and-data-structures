package Arrays;

import java.util.Stack;

/**
 * Given an integer array, you need to find one continuous subarray that if you 
 * only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 */
public class ShortestUnsortedSubarray {
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,2};

        System.out.println(findShortedUnsortedSubarray(arr));
        System.out.println(findShortedUnsortedSubarray2(arr));
    }

    private static int findShortedUnsortedSubarray(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int leftIndex = nums.length;
        int rightIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while(!s.isEmpty() && nums[i] < nums[s.peek()]){
                leftIndex = Math.min(leftIndex, s.pop());
            }
            s.push(i);
        }

        s.clear();
        for (int i = nums.length-1; i >= 0; i--) {
            while(!s.isEmpty() && nums[i] > nums[s.peek()]){
                rightIndex = Math.max(rightIndex, s.pop());
            }
            s.push(i);
        }

        return rightIndex - leftIndex > 0 ? rightIndex-leftIndex+1 : 0;
    }

    // constant space
    private static int findShortedUnsortedSubarray2(int nums[]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        boolean flag = false;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                flag = true;
            }

            if(flag){
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] > nums[i+1]){
                flag = true;
            }

            if(flag){
                max = Math.max(max, nums[i]);
            }
        }

        int leftIndex=0, rightIndex=nums.length-1;
        for(;leftIndex<nums.length; leftIndex++){
            if(min < nums[leftIndex]){
                break;
            }
        }

        for(;rightIndex>=0; rightIndex--){
            if(max > nums[rightIndex]){
                break;
            }
        }

        return rightIndex - leftIndex > 0 ? rightIndex-leftIndex+1 : 0;
    }
}
