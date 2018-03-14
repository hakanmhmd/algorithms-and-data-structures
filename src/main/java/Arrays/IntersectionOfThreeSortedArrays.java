package Arrays;

import java.util.List;

import java.util.ArrayList;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class IntersectionOfThreeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {2,3,6,8,12};
        int[] arr2 = {3,4,5,6,10,12,15};
        int[] arr3 = {6,8,10,12,15};

        List<Integer> intersection = findIntersection(arr1, arr2, arr3);
        System.out.println(intersection);
    }

    public IntersectionOfThreeSortedArrays() {
    }

    private static List<Integer> findIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int x=0;
        int y=0;
        int z=0;
        List<Integer> list = new ArrayList<>();
        while(x<arr1.length && y<arr2.length && z<arr3.length){
            if(arr1[x] == arr2[y] && arr2[y] == arr3[z]) {
                //add
                list.add(arr1[x]);
                x++;
                y++;
                z++;
            }
            else if(arr1[x] < arr2[y]){
                x++;
            } else if(arr2[y] < arr3[z]){
                y++;
            } else {
                z++;
            }
        }

        return list;
    }
}
