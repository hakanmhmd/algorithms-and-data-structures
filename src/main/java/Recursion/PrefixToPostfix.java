package Recursion;

import java.util.HashSet;
import java.util.Stack;
import java.util.Arrays;

/**
 * Given a Prefix expression, convert it into a Postfix expression.
 *
 * Addition: Infix = (A+B) * (C-D))
 */
public class PrefixToPostfix {
    public static void main(String[] args) {
        String prefix = "+*AB/CD";
        System.out.println(convert(prefix));
    }

    private static String convert(String prefix) {
        Stack<String> stack = new Stack<>();
        HashSet<Character> ops = new HashSet<>(Arrays.asList('+', '-', '=', '/', '*'));
        String reversed = new StringBuilder(prefix).reverse().toString();
        for(char ch: reversed.toCharArray()){
            if(!ops.contains(ch)){
                stack.push(Character.toString(ch));
            } else {
                String first = stack.pop();
                String second = stack.pop();
                stack.push(first + second + ch);
            }
        }

        return stack.pop();
    }
}
