package Stack;

/**
 * Implement a queue using stacks
 */
import java.util.Stack;

public class QueueViaStacks<T> {
    Stack<T> newest, oldest;

    public QueueViaStacks(){
        newest = new Stack<T>();
        oldest = new Stack<T>();
    }

    public void enqueue(T item){
        newest.push(item);
    }

    public T dequeue(){
        if(oldest.isEmpty()){
            shift();
            if(oldest.isEmpty()){
                System.out.println("The queue is empty");
                return null;
            }
        }
        return oldest.pop();
    }

    public T peek() {
        if(oldest.isEmpty()){
            shift();
        }
        return oldest.peek();
    }

    public void shift(){
        while(!newest.isEmpty()){
            oldest.push(newest.pop());
        }
    }

    public static void main(String[] args) {
        QueueViaStacks<Integer> queue = new QueueViaStacks<Integer>();

        queue.enqueue(2);
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
