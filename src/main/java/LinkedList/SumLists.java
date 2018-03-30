package LinkedList;

/**
 * Sum two numbers represented as linkedlists
 */
public class SumLists {

    public static void main(String[] args) {
        LinkedListNode lA1 = new LinkedListNode(7, null, null);
        LinkedListNode lA2 = new LinkedListNode(1, null, lA1);
        LinkedListNode lA3 = new LinkedListNode(6, null, lA2);
        LinkedListNode lA4 = new LinkedListNode(2, null, lA3);


        LinkedListNode lB1 = new LinkedListNode(5, null, null);
        LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
        LinkedListNode lB3 = new LinkedListNode(2, null, lB2);


        System.out.println("  " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        LinkedListNode result = addLists2(lA1, lB1);
        System.out.println("  " + result.printForward());
    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;
        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    private static LinkedListNode addLists2(LinkedListNode l1, LinkedListNode l2) {
        int carry = 0;
        LinkedListNode result = new LinkedListNode();
        LinkedListNode p1 = l1;
        LinkedListNode p2 = l2;
        LinkedListNode p3 = result;

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.data;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.data;
                p2 = p2.next;
            }

            p3.setNext(new LinkedListNode(carry % 10));
            p3 = p3.next;
           
            carry /= 10;
        }

        if(carry == 1){
            p3.data = 1;
        }

        return result.next;
    }
}
