package LinkedList;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Linkedlist implementation
 */
public class LinkedList<T> {
    // holds reference to the head
    private Node<T> head;
    private int listCount;

    public LinkedList() {
        head = null;
        listCount = 0;
    }

    private class Node<T> {
        // each hode has data and pointer to the next
        private T data;
        private Node<T> next;
        public Node(T data){ //constructor
            this.data = data;
            next = null;
        }
    }

    // O(1)
    public void addFirst(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
        listCount++;
    }

    public T removeFirst(){
        if(head != null){
            T data = head.data;
            head = head.next;
            return data;
        } else {
            throw new NoSuchElementException();
        }
    }

    // O(n)
    // Optimization keep pointer to tail for O(1)
    public void addLast(T data){
        Node<T> newNode = new Node<T>(data);
        if(head == null){
            addFirst(data);
            return;
        }

        Node<T> current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        listCount++;
    }

    // Inserts at specific index
    public void add(T data, int index){
        Node<T> newNode = new Node<T>(data);
        Node<T> current = head;
        if(current == null){
            head = newNode;
            return;
        }
        // go to the index or the end of list
        for (int i = 1; i < index && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        listCount++;
    }

    // Inserts a node after the node containing key
    public void addAfter(T key, T data){
        Node<T> current = head;
        while(current != null){
            if(current.data.equals(key)){
                break;
            }
            current = current.next;
        }

        if(current == null){
            System.out.println("Node with such key does not exist.");
        } else {
            Node<T> newNode = new Node<T>(data);
            newNode.next = current.next;
            current.next = newNode;
            listCount++;
        }
    }

    public boolean contains(T data) {
        Node<T> current = head;
        if(current == null){
            return false;
        }
        while(current != null){
            if(current.data .equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T get(int index){
        Node<T> current = head;
        if(current == null){
            throw new IndexOutOfBoundsException();
        }

        for(int i=0; i<index ; i++){
            current = current.next;
        }
        if(current == null){
            throw new IndexOutOfBoundsException();
        }
        return current.data;

    }


    public void remove(T data){
        if(head == null){
            System.out.println("Can'delete");
            return;
        }
        if(head.data.equals(data)){
            head = head.next;
            return;
        }
        Node<T> current = head;
        Node<T> previous = null;

        while(current != null){
            if(current.data.equals(data)){
                break;
            }
            previous = current;
            current = current.next;
        }

        if(current == null){
            System.out.println("Element does not exist.");
            return;
        }

        previous.next = current.next;
        listCount--;
    }

    public int size(){
        return listCount;
    }

    // O(n)
    public LinkedList<T> reverse(){
        LinkedList<T> list = new LinkedList<T>();
        Node<T> current = head;

        while(current != null){
            list.addFirst(current.data);
            current = current.next;
        }
        return list;
    }

    public void printList(){
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addLast(10);
        list.addFirst(0);
        list.addLast(20);

        list.printList();

        list.remove(30);

        LinkedList<Integer> reversed = list.reverse();

        reversed.printList();

        list.addAfter(50, 5);

        list.printList();

        System.out.println(list.size());
    }

}
