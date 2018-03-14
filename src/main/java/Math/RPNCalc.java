package Math;

import java.util.*;

/**
 * Created by hakanmehmed on 01/03/2018.
 */
public class RPNCalc {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        String input = " 3 4 + 5 6 + x =";
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, input.trim().split(" "));
        al.removeAll(Arrays.asList(null, ""));
        calculate(al);
    }

    private static void calculate(ArrayList<String> input) {
        for (String s : input) {
            try {
                int next = Integer.valueOf(s);
                stack.push(next);
            } catch (Exception e){
                if(Objects.equals(s, "+")){
                    //check if there are two elements
                    stack.push(stack.pop() + stack.pop());
                } else if(Objects.equals(s, "-")){
                    //check if there are two elements
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(first - second);// order matters here

                } else if(Objects.equals(s, "*") || Objects.equals(s, "x")){
                    //check if there are two elements
                    stack.push(stack.pop() * stack.pop());
                } else if(Objects.equals(s, "/")){
                    //check if there are two elements
                    int denom = stack.pop();
                    int nom = stack.pop();
                    if(denom == 0) {
                        stack.push(0); // throw an Exception
                    } else {
                        stack.push(nom / denom);
                    }
                } else if(Objects.equals(s, "=")){
                    System.out.println(stack.pop());
                }
            }
        }
    }
}
