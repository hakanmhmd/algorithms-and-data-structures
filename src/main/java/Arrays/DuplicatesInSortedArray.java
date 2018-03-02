package Arrays;

/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 */
public class DuplicatesInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,3};
        int i = removeDuplicates(arr);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.print(arr[j] + " ");

        }
    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return 1;

        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[i]){
                nums[i+1] = nums[j];
                i++;
            }
        }

        return i+1;

    }
}
