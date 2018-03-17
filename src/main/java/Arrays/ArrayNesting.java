package Arrays;

/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return
 * the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 */
public class ArrayNesting {

    public static void main(String[] args) {
        int[] arr = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(arr));
    }

    public static int arrayNesting(int[] nums) {
        int max = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != Integer.MAX_VALUE){
                int n = generateSet(nums, i);
                if(n > max) max = n;
            }
        }

        return max;
    }

    static int generateSet(int[] nums, int i){
        int count = 0;
        int current = nums[i];
        while(nums[current] != Integer.MAX_VALUE){
            int temp = current;
            current = nums[current];
            nums[temp] = Integer.MAX_VALUE;
            count++;
        }
        return count;
    }

}
