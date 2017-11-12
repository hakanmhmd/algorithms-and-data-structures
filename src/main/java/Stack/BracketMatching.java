package Stack;

import java.util.Stack;

/**
 * Given bracket expression decided if it is balanced or not
 */
public class BracketMatching {
    public static void main(String[] args) {
        String exp = "[(){()[]()}[()()()]]";

        System.out.println(checkBrackets(exp));
    }

    private static boolean checkBrackets(String exp) {
        if(exp.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<exp.length(); i++){
            char current = exp.charAt(i);

            if(current == '(' || current == '{' || current == '['){
                stack.push(current);
            }

            if(current == ')') {
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            } else if (current == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            } else if (current == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
