package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Give north bank and south bank coordination of bridges build as many bridges as possible
 * so that they dont cross over each other
 */
public class BuildingBridges {
    static class Bridge {
        int north;
        int south;

        Bridge(int n, int s) {
            this.north = n;
            this.south = s;
        }

        @Override
        public String toString() {
            return north + ", " + south;
        }
    }

    //sort with respect to south coords (if same sort based on north)
    //find LIS in northern coordinates
    // len of LIS is the answer
    public static void main(String[] args) {
        int[] north = {0, 2, 1, 1};
        int[] south = {1, 4, 4, 3};

        System.out.println(build(north, south));
    }

    private static int build(int[] north, int[] south) {
        ArrayList<Bridge> bridgeArrayList = new ArrayList<>();
        for (int i = 0; i < north.length; i++) {
            bridgeArrayList.add(new Bridge(north[i], south[i]));
        }

        Collections.sort(bridgeArrayList, (o1, o2) -> {
            if (o1.south != o2.south) {
                return o1.south - o2.south;
            } else {
                return o1.north - o2.north;
            }
        });

        int[] northSorted = new int[north.length];
        int i=0;
        for (Bridge bridge : bridgeArrayList) {
            northSorted[i++] = bridge.north;
        }

        System.out.println(Arrays.toString(northSorted));

        return LongestIncreasingSubsequence.findLIS(northSorted);
    }




}
