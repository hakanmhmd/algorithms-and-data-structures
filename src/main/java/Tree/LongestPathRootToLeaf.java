package Tree;

import java.util.ArrayList;

/**
 * Print longest path from root to leaf
 */
public class LongestPathRootToLeaf {
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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(40);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(14);
        root.right.right = new Node(45);
        root.right.right.right = new Node(50);
        root.right.right.right.right = new Node(80);
        root.right.right.right.left = new Node(46);
        root.right.right.right.left.right = new Node(48);

        ArrayList<Integer> res = new ArrayList<>();
        longestPath(root, res);
        System.out.println(res);
    }

    private static void longestPath(Node root, ArrayList<Integer> list) {
        list.add(root.data);

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left > right && root.left != null){
            longestPath(root.left, list);
        } else if(root.right != null) {
            longestPath(root.right, list);
        }

    }

    private static int maxDepth(Node root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
