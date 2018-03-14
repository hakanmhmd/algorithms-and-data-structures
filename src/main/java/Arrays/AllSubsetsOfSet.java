package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * O(2^n)
 */
public class AllSubsetsOfSet {
    public static void main(String[] args) {
        Integer[] set = {0, 1, 2, 3};
        findAllSubsets(set);
        System.out.println();
        subsets(set);
    }

    private static void findAllSubsets(Integer[] set) {
        Integer[] subset = new Integer[set.length];
        helper(set, subset, 0);
    }

    private static void helper(Integer[] set, Integer[] subset, int i) {
        if(i == set.length){
            printSet(subset);
        } else {
            subset[i] = null;
            helper(set, subset, i+1);
            subset[i] = set[i];
            helper(set, subset, i+1);
        }
    }

    private static void subsets(Integer[] set){
        Arrays.sort(set);
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0; i<=set.length; i++){
            subsetHelper(set, i, 0, l, new ArrayList<>());
        }

        for (List<Integer> integers : l) {
            System.out.println(integers);
        }
    }

    private static void subsetHelper(Integer[] set, int current, int start, List<List<Integer>> l, ArrayList<Integer> curr){
        if(curr.size() == current){
            l.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start; i<set.length; i++){
            curr.add(set[i]);
            subsetHelper(set, current, i+1, l, curr);
            curr.remove(curr.size()-1);
        }
    }

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null)
            return null;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < S.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

            //get sets that are already in result
            for (ArrayList<Integer> a : result) {
                temp.add(new ArrayList<>(a));
            }

            //add S[i] to existing sets
            for (ArrayList<Integer> a : temp) {
                a.add(S[i]);
            }

            //add S[i] only as a set
            ArrayList<Integer> single = new ArrayList<>();
            single.add(S[i]);
            temp.add(single);

            result.addAll(temp);
        }

        //add empty set
        result.add(new ArrayList<>());

        return result;
    }


    private static void printSet(Integer[] set) {
        System.out.print("{");
        for (int i = 0; i < set.length-1; i++) {
            if(set[i] != null) {
                System.out.print(set[i] + ", ");
            }
        }
        if(set[set.length-1] != null)
            System.out.print(set[set.length-1]);
        System.out.println("}");
    }
}
