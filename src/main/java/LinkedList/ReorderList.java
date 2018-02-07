package LinkedList;


/**
 * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
 */
public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
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

        printList(n1);
        reorderList(n1);
        printList(n1);
    }

    private static void reorderList(ListNode n) {
        if(n != null && n.next != null) {
            ListNode slow = n;
            ListNode fast = n;

            while(fast != null && fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode secondHalf = slow.next;
            slow.next = null;
            secondHalf = reverseList(secondHalf);

            ListNode p1 = n;
            ListNode p2 = secondHalf;

            while(p2 != null){
                ListNode temp1 = p1.next;
                ListNode temp2 = p2.next;

                p1.next = p2;
                p2.next = temp1;

                p1 = temp1;
                p2 = temp2;
            }
        }
    }

    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode current = head.next;
        while (current != null){
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        head.next = null;
        return pre;
    }

    private static void printList(ListNode n) {
        System.out.println("------");
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

}
