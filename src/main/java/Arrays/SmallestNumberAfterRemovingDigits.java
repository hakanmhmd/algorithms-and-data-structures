package Arrays;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 */
public class SmallestNumberAfterRemovingDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        System.out.println(smallestNum(num, k));
    }

    private static String smallestNum(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<num.length(); i++){
            if(stack.isEmpty() || num.charAt(i) >= stack.peek()){
                stack.push(num.charAt(i));
            } else {
                while(k>0 && !stack.isEmpty() && num.charAt(i) < stack.peek()){
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
            }
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }


        int i=0;
        for(; i<sb.length(); i++){
            if(sb.charAt(i) != '0') break;
        }

        return i == sb.length() ? "0" : sb.toString().substring(i);
    }
}
