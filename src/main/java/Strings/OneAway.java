package Strings;

import static org.junit.Assert.assertEquals;

/**
 * Check if two string a one edit/insert away from each other
 */
public class OneAway {
    public static void main(String[] args) {
        String[][] tests = {
                {"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}
        };

        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");
            boolean result = oneEditAway(a, b);

            assertEquals(expected, result);
        }
    }

    private static boolean oneEditReplace(String a, String b) {
        boolean oneDifference = false;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!= b.charAt(i)){
                if(oneDifference) return false;
                oneDifference = true;
            }
        }

        return true;
    }

    private static boolean oneEditInsert(String a, String b) {
        int index1=0, index2=0;
        boolean oneDifference = false;
        while(index1 < a.length() && index2 < b.length()){
            if(a.charAt(index1) != b.charAt(index2)){
                if(oneDifference) return false;
                oneDifference = true;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private static boolean oneEditAway(String a, String b) {
        if(a.length() == b.length()){
            return oneEditReplace(a, b);
        } else if(a.length() + 1 == b.length()){
            return oneEditInsert(a, b);
        } else if(a.length() == b.length() + 1){
            return oneEditInsert(b, a);
        }

        return false;
    }

}
