package Stack;

import java.util.Stack;

/**
 * Stack with max() operation in O(1)
 */
public class MaxStack extends Stack<Integer> {
    Stack<Integer> s2;

    public MaxStack() {
        s2 = new Stack<>();
    }

    public void push(int value){
        if(value >= max()){
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(value == max()){
            s2.pop();
        }
        return value;
    }

    public int max() {
        if(s2.isEmpty()){
            return Integer.MIN_VALUE;
        } else {
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        MaxStack stack2 = new MaxStack();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack2.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack2.pop());
            System.out.println("New max is " + stack2.max());
        }
    }
}
