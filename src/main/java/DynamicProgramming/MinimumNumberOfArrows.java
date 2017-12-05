package DynamicProgramming;

import java.util.Arrays;

/**
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence
 * the x-coordinates of start and end of the diameter suffice. Start is always smaller than end.
 * There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely.
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 */
public class MinimumNumberOfArrows {
    public static void main(String[] args) {
        int[][] ballons = {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };

        System.out.println(minNumberOfArrows(ballons));
    }

    private static int minNumberOfArrows(int[][] ballons) {
        if(ballons==null || ballons.length==0) return 0;

        Arrays.sort(ballons, (a,b) -> a[0]-b[0]);
        int count = 1;
        int end = ballons[0][1];
        for (int i = 1; i < ballons.length; i++) {
            if(ballons[i][0] < end){
                end = Math.min(end, ballons[i][1]);
            } else {
                count++;
                end = ballons[i][1];
            }
        }

        return count;
    }
}
