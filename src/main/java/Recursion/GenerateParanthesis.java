package Recursion;

import java.util.ArrayList;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class GenerateParanthesis {
    public static void main(String[] args) {
        int n = 3;

        ArrayList<String> list = new ArrayList<>();
        generateParanthesis("", n, n, list);
        System.out.println(list);
    }

    private static void generateParanthesis(String current, int openRemaining,
                                                         int closeRemaining, ArrayList<String> list) {
        if(closeRemaining == 0){
            list.add(current);
            return;
        }
        if(openRemaining > 0){
            generateParanthesis(current + "(", openRemaining-1, closeRemaining, list);
            if(openRemaining < closeRemaining){
                generateParanthesis(current + ")", openRemaining, closeRemaining-1, list);
            }
        } else {
            generateParanthesis(current + ")", openRemaining, closeRemaining-1, list);
        }
    }
}
