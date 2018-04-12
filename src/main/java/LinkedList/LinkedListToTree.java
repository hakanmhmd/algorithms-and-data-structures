package LinkedList;

/**
 * Convert sorted linkedlist into a BST
 */
public class LinkedListToTree {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node node = convertToTree(n1);

        print(node);
    }

    private static void print(Node node) {
        if(node == null) return;
        print(node.left);
        System.out.println(node.data + " ");
        print(node.right);
    }

    private static Node convertToTree(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }

    private static Node toBST(ListNode head, ListNode tail) {
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        Node current = new Node(slow.val);
        current.left = toBST(head, slow);
        current.right = toBST(slow.next, tail);

        return current;
    }
}
