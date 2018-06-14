package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementing a stack using two queues
 */
public class StackViaQueues {
    Queue<Integer> q1, q2;

    // q1 will be kept empty
    public StackViaQueues(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    private Integer pop() {
        if(q2.isEmpty()) {
            System.out.println("Empty queue");
            return null;
        }
        return q2.poll();
    }

    private void push(int i) {
        q1.offer(i);
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
    }

    public static void main(String[] args) {
        StackViaQueues stack = new StackViaQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.pop();
    }

}
