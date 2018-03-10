package Arrays;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by hakanmehmed on 10/03/2018.
 */
public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k=4;
        int x = -1;
        System.out.println(findClosestElements(arr, k ,x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ind = findIndex(arr, x);
        int r = ind+1;
        List<Integer> l = new ArrayList<>();
        if(arr[ind] == x){
            l.add(arr[ind]);
            ind--;
        }

        while(ind >= 0 && r < arr.length && l.size() != k){

            if(x - arr[ind] <= arr[r] - x) {
                l.add(arr[ind]);
                ind--;
            } else {
                l.add(arr[r]);
                r++;
            }
        }

        while(ind >= 0 &&  l.size() != k){
            l.add(arr[ind]);
            ind--;
        }

        while(r<arr.length && l.size() != k){
            l.add(arr[r]);
            r++;
        }
        Collections.sort(l);
        return l;
    }

    public static int findIndex(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            if(arr[left] > target) return left;
            if(arr[right] <= target) return right;
            int mid = left + (right-left)/2;

            if(arr[mid] <= target && arr[mid+1] > target){
                return mid;
            } else if(arr[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return -1;
    }
}
