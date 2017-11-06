package Arrays;

import java.util.Arrays;

/**
 * O(2^n)
 */
public class AllSubsetsOfSet {
    public static void main(String[] args) {
        Integer[] set = {0, 1, 2, 3};
        findAllSubsets(set);
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
