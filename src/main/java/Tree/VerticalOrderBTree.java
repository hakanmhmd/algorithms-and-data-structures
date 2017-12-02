package Tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/** Print a Binary Tree in Vertical Order
 *
 * HD for root is 0,
 * a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and
 * a left edge is considered as -1 horizontal distance.
 *
 * Preorder traversal -> root, left, right
 * For every hd value maintain a list of nodes in a hashmap
 *
 * O(n)
 *
**/
 public class VerticalOrderBTree {
    static class Node {
        int key;
        Node right;
        Node left;

        public Node(int data){
            this.key = data;
            right = null;
            left = null;
        }
    }

    // hd - horizontal distance
    static void getVerticalOrder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> m){
        if(root == null) return;

        ArrayList<Integer> list = m.get(hd);

        if(list == null){
            list = new ArrayList<>();
            list.add(root.key);
        } else {
            list.add(root.key);
        }

        m.put(hd, list);

        getVerticalOrder(root.left, hd-1, m);
        getVerticalOrder(root.right, hd+1, m);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }

    private static void printVerticalOrder(Node root) {
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int rootHd = 0;
        getVerticalOrder(root, rootHd, m);

        for(Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
