package LinkedList;

/**
 * Created by hakanmehmed on 11/03/2018.
 * Doubly linked list implementation from scratch
 */
public class DoublyLinkedList {
    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node addFront(int value) {
        Node node = new Node(value);
        return addFront(node);
    }

    public Node addFront(Node node) {
        if(node == null) return null;
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }

        return node;
    }

    public Node addLast(int value) {
        Node node = new Node(value);
        return addLast(node);
    }


    public Node addLast(Node node) {
        if(node == null) return null;
        node.next = null;
        node.prev = tail;

        if (tail == null) {
            return addFront(node);
        }

        tail.next = node;
        return node;
    }

    public void remove(Node node){
        if(node == null) return;

        /* Change next only if node to be deleted is NOT the last node */
        if(node.next != null){
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        /* Change prev only if node to be deleted is not the first node */
        if(node.prev != null){
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
    }


    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions*/
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node six = dll.addFront(6);
        Node seven = dll.addFront(7);
        Node one = dll.addFront(1);
        Node eight = dll.addLast(8);
        Node four = dll.addFront(4);

        dll.print();

        dll.remove(eight);
        dll.remove(four);
        dll.remove(seven);
        dll.print();
    }
}
