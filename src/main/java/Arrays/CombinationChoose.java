package Arrays;

import java.util.ArrayList;

/**
 * Create all combination for choosing 3 out 5 options
 */
public class CombinationChoose {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 3;

        System.out.println(combinations(arr, n));
    }

    private static ArrayList<ArrayList<Integer>> combinations(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), arr, n, 0);
        return res;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr, int n, int start) {
        if(temp.size() == n){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start; i<arr.length; i++){
            temp.add(arr[i]);
            backtrack(res, temp, arr, n, i+1);
            temp.remove(temp.size()-1);
        }

    }
}
