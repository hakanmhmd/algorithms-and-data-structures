package Stack;

import java.util.Random;
import java.util.Stack;

/**
 * Sort a stack in ascending order - use an auxiliary stack
 */
public class SortStack {
    public static void main(String[] args) {
        Random rm = new Random();
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            s.push(rm.nextInt(10) + 1);
        }

        sort(s);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void sort(Stack<Integer> s) {
        Stack<Integer> helper = new Stack<>();

        while(!s.isEmpty()){
            int top = s.pop();
            while(!helper.isEmpty() && helper.peek() > top){
                s.push(helper.pop());
            }

            helper.push(top);
        }

        //copy back to s
        while(!helper.isEmpty()){
            s.push(helper.pop());
        }
    }

}
