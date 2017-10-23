package DesignPatterns.template;

import java.util.Set;

/**
 * Created by hakanmehmed on 05/07/2017.
 */
public class Result {
    private Set<String> result;
    public Result(Set<String> result){
        this.result = result;
    }

    public void printOutput() {
        System.out.print("[ ");
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.print(" ]");
    }
}
