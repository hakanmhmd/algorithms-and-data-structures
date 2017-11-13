package Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {
    class StackElement {
        public int value;
        public int min;
        public StackElement next;

        public StackElement(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    public StackElement top;

    public void push(int x){
        if(top == null){
            top = new StackElement(x, x);
        } else {
            StackElement e = new StackElement(x, Math.min(x, top.min));
            e.next = top;
            top = e;
        }
    }

    public StackElement pop(){
        if(top == null) return null;
        StackElement e = top;
        top = top.next;
        return e;
    }

    public int getMin(){
        if(top == null) return Integer.MIN_VALUE;
        return top.min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        int[] array = {8, 3, 2, 4, 8, 1};
        for (int value : array) {
            stack.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop().value);
            System.out.println("New min is " + stack.getMin());
        }
    }
}
