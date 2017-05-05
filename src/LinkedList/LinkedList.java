package LinkedList;

/**
 * Linkedlist implementation
 */
public class LinkedList {
    // holds reference to the head
    private Node head;
    private int listCount;

    public LinkedList() {
        head = null;
        listCount = 0;
    }

    private class Node {
        // each hode has data and pointer to the next
        int data;
        Node next;
        Node(int data){ //constructor
            this.data = data;
            next = null;
        }
    }

    // O(1)
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        listCount++;
    }

    // O(n)
    // Optimization keep pointer to tail for O(1)
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = null;

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        listCount++;
    }

    public void addAfter(){

    }

    public void remove(){

    }

    public int size(){
        return listCount;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(0);

        list.printList();
        System.out.println(list.size());
    }
}
