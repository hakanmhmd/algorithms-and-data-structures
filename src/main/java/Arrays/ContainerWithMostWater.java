package Arrays;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line
 * i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,5,8,3,7};
        System.out.println(largestContainerArea(arr));
    }

    private static int largestContainerArea(int[] arr) {
        int maxArea = 0;
        int left = 0;
        int right = arr.length-1;

        while(left != right){
            maxArea = Math.max(maxArea, Math.min(arr[left], arr[right]) * (right-left));
            if(arr[left] < arr[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
