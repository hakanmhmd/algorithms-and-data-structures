package LinkedList;


import java.util.LinkedList;

/**
 * Given a linked list, in addition to the next pointer, each node has a child pointer that can point to a
 * separate list. With the head node, flatten the list to a single-level linked list.
 */
public class FlattenLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode(int x) {
            val = x;
            next = null;
            child = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);

        n1.next = n2;
        n2.child = n5;
        n5.next = n6;
        n5.child = n8;
        n2.next = n3;
        n3.next = n4;
        n4.child = n7;
        n7.child = n9;


        flatten(n1);
        System.out.println();
        flattenInPlace(n1);
    }

    private static void flattenInPlace(ListNode node) {
        ListNode A = node;
        ListNode B;
        while(A != null) {
            B = node;
            while (A.next != null) {
                System.out.print(A.val + " ");
                A = A.next;
            }

            while (B!=null && B.child == null) {
                B = B.next;
            }
            if(B == null) return;
            A.next = B.child;
            B.child = null;
        }
        System.out.print(A.val + "");
    }

    private static void flatten(ListNode node) {
        LinkedList<ListNode> q = new LinkedList<>();

        ListNode current = node;

        while(current != null || !q.isEmpty()){
            System.out.print(current.val + " ");
            if(current.child != null){
                q.add(current.child);
            }
            current = current.next;
            if(current == null){
                current = q.poll();
            }
        }
    }


}
