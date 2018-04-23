package Arrays;

import java.util.*;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class CombinationSum {
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

    /*
    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sums to target.
    The same repeated number may be chosen from candidates unlimited number of times.
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private void combinations(List<List<Integer>> res, ArrayList<Integer> temp, int[] candidates, int target, int start) {
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            temp.add(candidates[i]);
            combinations(res, temp, candidates, target-candidates[i], i); // not i + 1 because we can reuse same elements
            temp.remove(temp.size()-1);
        }
    }

    /*
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sums to target.
    Each number in candidates may only be used once in the combination.
     */

    private void combinations2(List<List<Integer>> res, ArrayList<Integer> temp, int[] candidates, int target, int start) {
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            if(i>start && candidates[i] == candidates[i-1]) continue; // skip dups
            temp.add(candidates[i]);
            combinations2(res, temp, candidates, target-candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}
