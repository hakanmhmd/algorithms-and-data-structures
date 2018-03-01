package Stack;

import java.util.Stack;

/**
 * First remove all the balanced brackets
 */
public class MinChangesBrackets {
    public static void main(String[] args) {
        String bracketExpr = "))((((";

        System.out.println(findMinChanges(bracketExpr));
    }

    private static int findMinChanges(String bracketExpr) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < bracketExpr.length(); i++) {
            char c = bracketExpr.charAt(i);
            if(c == '('){
                s.push(c);
            } else {
                if(!s.isEmpty()) {
                    if (s.peek() == '(') {
                        s.pop();
                    } else {
                        s.push(c);
                    }
                } else {
                    s.push(c);
                }
            }
        }

        int left = 0;
        int right = 0;

        while(!s.isEmpty()){
            if(s.pop() == '(') left++;
            else right++;
        }

        return left/2 + right/2;
    }
}
