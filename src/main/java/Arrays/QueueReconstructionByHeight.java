package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of
 * integers (h, k), where h is the height of the person and k is the number of people in front of
 * this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 */
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] arr = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        System.out.println(Arrays.deepToString(reconstruct(arr)));
    }

    private static int[][] reconstruct(int[][] arr) {
        if(arr==null || arr.length == 0) return null;

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] != o2[0]) return o2[0] - o1[0];
            return o1[1]-o2[1];
        });

        ArrayList<int[]> temp = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            temp.add(arr[i][1], arr[i]);
        }

        int[][] res = new int[arr.length][arr[0].length];
        for(int i=0; i<temp.size(); i++){
            res[i][0] = temp.get(i)[0];
            res[i][1] = temp.get(i)[1];
        }

        return res;

    }
}
