package Arrays;

/**
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] arr = {2,3, 5 ,10 ,3};
        System.out.println(checkPossibility(arr));
        System.out.println(checkPossibility2(arr));
    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            if(i == 0){
                if(nums[i] > nums[i+1]){
                    cnt++;
                    nums[i] = nums[i+1];
                }
            } else {
                if(nums[i] > nums[i+1]){
                    if(nums[i+1] >= nums[i-1]){ // 3,10,5 -> 3,3,3
                        nums[i] = nums[i-1];
                    } else {
                        nums[i+1] = nums[i]; // 5, 10, 3 -> 5, 10, 10
                    }
                    cnt++;
                }
            }
        }
        return cnt <= 1;
    }

    public static boolean checkPossibility2(int[] nums) {
        int index = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
               if(index != Integer.MIN_VALUE) return false;
                index = i;
            }
        }

        return index == Integer.MIN_VALUE ||
                index == 0 ||
                index == nums.length-2 ||
                nums[index-1] <= nums[index + 1] ||
                nums[index] <= nums[index+2];
    }


}
