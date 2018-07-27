package LinkedList;

/**
 * An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev 
 * fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an 
 * XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns
 * the node at index.
 *
 * Cant be implemented in Java because it does not have pointers
 *
 * In C:
 *   struct Node* XOR (struct Node *a, struct Node *b) {
       return (struct Node*) ((uintptr_t) (a) ^ (uintptr_t) (b));
     }
 */
public class XORDoublyLinkedList {
    class Node {
        int val;
        Node both; // xor of prev and next

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public XORDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) {

    }

    private Node get(int index) {

        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null && index > 0){
            next = xor(prev, curr.both);
            prev = curr;
            curr = next;
            index--;
        }
        return curr;
    }

    private void add(int element) {
        Node newNode = new Node(element);
        newNode.both = xor(tail, null); //xor of last node and null

        if(head == null){
            head = newNode;
        }

        if(tail != null){
            // current tail.both is prev xor null
            Node prev = xor(tail.both, null);
            tail.both = xor(prev, newNode);
        }

        tail = newNode;

    }

    private Node xor(Node a, Node b){
        return dereferencePointer(getPointer(a) ^ getPointer(b));
    }

    private int getPointer(Node node){
        return 0; // assume implemented
    }

    private Node dereferencePointer(int addr){
        return new Node(addr); // assume implemented
    }
}
