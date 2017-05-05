package LinkedList;

/**
 * Linkedlist implementation
 */
public class LinkedList {
    // holds reference to the head
    Node head;

    private static class Node {
        // each hode has data and pointer to the next
        int data;
        Node next;
        Node(int data){ //constructor
            this.data = data;
            next = null;
        }
    }
}
