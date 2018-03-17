package Arrays;

import java.util.List;

import java.util.ArrayList;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class PermutationSum {
    public static void main(String[] args) {
        int k = 3, n = 9;
        List<List<Integer>> lists = combinationSum3(k, n);
        System.out.println(lists);

    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    static void combinations(List<List<Integer>> res, ArrayList<Integer> comb, int k, int n, int currentDigit){
        if(comb.size() == k && n==0){
            List<Integer> temp = new ArrayList<Integer>(comb);
            res.add(temp);
        }

        for(int i=currentDigit; i<= 9; i++){
            comb.add(i);
            combinations(res, comb, k, n-i, i+1);
            comb.remove(comb.size()-1);
        }
    }
}
