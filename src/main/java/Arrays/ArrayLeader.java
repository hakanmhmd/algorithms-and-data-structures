package Arrays;

import java.util.ArrayList;

/**
 * Leader is an element which is larger than all the elements in the array to its right
 */
public class ArrayLeader {
    public static void main(String[] args) {
        int[] arr = {97, 23, 54, 12, 20, 7, 27};
        System.out.println(findLeaders(arr));
    }

    private static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leader = new ArrayList<>();
        if(arr == null || arr.length == 0) return leader;
        int currentLeader = arr[arr.length-1];
        leader.add(currentLeader);

        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] > currentLeader){
                currentLeader = arr[i];
                leader.add(currentLeader);
            }
        }
        return leader;
    }
}
