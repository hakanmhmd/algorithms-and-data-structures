package LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * log(k) * n
 */
public class MergeKSortedLinkedLists {
    static Random rnd = new Random();
    public static void main(String[] args) {


        LinkedListNode head1 = createList();
        LinkedListNode head2 = createList();
        LinkedListNode head3 = createList();
        System.out.println(head1.printForward());
        System.out.println(head2.printForward());
        System.out.println(head3.printForward());


        LinkedListNode result = mergeKLists(new LinkedListNode[] {head1, head2, head3});
        System.out.println(result.printForward());
    }

    private static LinkedListNode mergeKLists(LinkedListNode[] lists) {
        if (lists==null || lists.length==0){
            return null;
        }

        PriorityQueue<LinkedListNode> queue = new PriorityQueue<>((o1, o2) -> o1.data - o2.data);

        LinkedListNode head = new LinkedListNode();
        LinkedListNode p = head;

        for (LinkedListNode list : lists) {
            if(list!=null){
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()){
            LinkedListNode n = queue.poll();
            p.next = n;
            p = p.next;
            if(n.next!=null){
                queue.offer(n.next);
            }
        }

        return head.next;
    }


    private static LinkedListNode createList(){
        int[] arr = new int[10];
        for (int x = 0; x < arr.length; x++) {
            arr[x] = rnd.nextInt(100);
        }
        Arrays.sort(arr);
        LinkedListNode[] nodes = new LinkedListNode[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new LinkedListNode(arr[i], null, null);
        }

        for (int i = 0; i < 10; i++) {
            if (i < 10 - 1) {
                nodes[i].setNext(nodes[i + 1]);
            }
            if (i > 0) {
                nodes[i].setPrevious(nodes[i - 1]);
            }
        }
        return nodes[0];
    }
}
