package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes an integer n and return all possible combinations of its factors.
 */
public class FactorCombinations {
    public static void main(String[] args) {
        int n = 16;

        System.out.println(getFactors(n));
    }

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(2, 1, n, result, list);
        return result;
    }

    private static void helper(int start, int p, int n, List<List<Integer>> result, List<Integer> list) {
        if(start > n || p > n) return;

        if(p == n){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<n; i++){
            if(i*p>n) break;

            if(n%i==0){
                list.add(i);
                helper(i, i*p, n, result, list);
                list.remove(list.size()-1);
            }
        }
    }
}
