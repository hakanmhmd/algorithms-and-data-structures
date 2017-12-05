package Arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Given an array of distinct elements and a number x, find if there is a pair with product equal to x.
 */
public class PairProduct {
    public static void main(String[] args) {
        int arr[] = {10, 20, 9, 0, 40};
        int x = 360;
        ArrayList<Pair<Integer, Integer>> productPairs = findProductPairs(arr, x);
        for (int i = 0; i < productPairs.size(); i++) {
            System.out.println(productPairs.get(i).getKey() + ", " + productPairs.get(i).getValue());
        }
    }

    private static ArrayList<Pair<Integer, Integer>> findProductPairs(int[] arr, int x) {
        HashSet<Integer> seen = new HashSet<>();
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                if(x == 0) {
                    for (int j = 0; j < arr.length; j++) {
                        result.add(new Pair<>(arr[i], arr[j]));
                    }
                }
            } else {
                if (x % arr[i] == 0) {
                    if (seen.contains(x / arr[i])) {
                        result.add(new Pair<>(arr[i], x / arr[i]));
                    }
                }
                seen.add(arr[i]);
            }
        }
        return result;
    }


}
