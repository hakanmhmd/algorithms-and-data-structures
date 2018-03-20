package Arrays;

import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.


 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] towers = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trappingWater(towers));
        System.out.println(trappingWater2(towers));
    }

    // O(n) space
    private static int trappingWater(int[] towers) {
        int[] rightMax = new int[towers.length];

        int maxSeen = 0;
        for(int i=towers.length-1; i>=0; i--){
            if(towers[i] > maxSeen){
                maxSeen = towers[i];
                rightMax[i] = maxSeen;
            } else {
                rightMax[i] = maxSeen;
            }
        }

        System.out.println(Arrays.toString(rightMax));

        int water = 0;
        int maxSeenLeft = 0;
        for(int i=0; i<towers.length; i++){
            water += Math.max(Math.min(maxSeenLeft, rightMax[i]) - towers[i], 0);
            maxSeenLeft = Math.max(maxSeenLeft, towers[i]);
        }

        return water;
    }

    // O(1) space - two pointers
    //So, we can say that if there is a larger bar at one end(say right), we are assured that
    // the water trapped would be dependant on height of bar in current direction(from left to right).
    // As soon as we find the bar at other end(right) is smaller, we start iterating in opposite
    // direction(from right to left).
    private static int trappingWater2(int[] towers) {
        int left = 0;
        int right = towers.length-1;

        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while(left < right){
            if(towers[left] < towers[right]){ // water only depends on left height
                if(towers[left] >= leftMax){
                    leftMax = towers[left];
                } else {
                    water += leftMax - towers[left];
                }
                left++;
            } else {
                if(towers[right] >= rightMax) { // water depends on right height
                    rightMax = towers[right];
                } else {
                    water += rightMax - towers[right];
                }
                right--;
            }
        }

        return water;
    }
}
