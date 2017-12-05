package LinkedList;

import java.util.Stack;

/**
 * Check if a linked list is palindrome
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int length = 9;
        LinkedListNode[] nodes = new LinkedListNode[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
        }

        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        // nodes[length - 2].data = 9; // Uncomment to ruin palindrome

        LinkedListNode head = nodes[0];
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null){
            stack.push(slow.data);
            System.out.println("Pushing " + slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //odd number of elements
        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            System.out.println("Comparing " + stack.peek() + " " + slow.data);
            if(stack.pop() != slow.data){
                return false;
            }
            slow = slow.next;
        }


        return true;
    }
}
