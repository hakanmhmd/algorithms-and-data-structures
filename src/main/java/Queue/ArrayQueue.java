package Queue;

import java.util.*;

/**
 * Generic Queue implementation using an array
 */

public class ArrayQueue<Item> implements Queue<Item> {
    private static final int DEFAULT_CAPACITY = 16;
    private Item[] queue;
    private int rear;

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        this.queue = (Item[]) new Object[capacity];
    }

    private void expand() {
        Item[] tmp = (Item[]) new Object[queue.length * 2];
        // copy the elements
        for (int i = 0; i < queue.length; i++) {
            tmp[i] = queue[i];
        }
        this.queue = tmp;
    }

    public void enqueue(Item i){
        if(size() == queue.length){
            expand();
        }

        queue[rear] = i;
        rear++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new EmptyStackException();
        Item i = queue[0];

        //shift elements to position 0
        for (int j = 0; j < rear; j++) {
            queue[j] = queue[j+1];
        }
        rear--;
        return i;

    }

    public Item peek(){
        if (isEmpty()) throw new EmptyStackException();
        return queue[0];
    }

    public boolean isEmpty(){
        return rear == 0;
    }

    public int size(){
        return rear;
    }

    public String toString(){
        return Arrays.toString(queue);
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.toString());

        queue.dequeue();
        System.out.println(queue.toString());
    }

}
