package Tree;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
 connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 */
public class BinaryTreeLongestConsecutiveSequence {
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.right = new Node(3);
        root1.right.left = new Node(2);
        root1.right.right = new Node(4);
        root1.right.right.right = new Node(5);
        root1.right.right.right.right = new Node(7);
        root1.right.right.right.right.left = new Node(8);

        longestSequence(root1);
        System.out.println(max);

        System.out.println(longestConsecutive(root1));
    }

    private static int longestSequence(Node p) {
        if (p == null) return 0;
        int L = longestSequence(p.left) + 1;
        int R = longestSequence(p.right) + 1;
        if (p.left != null && p.data + 1 != p.left.data) {
            L = 1;
        }
        if (p.right != null && p.data + 1 != p.right.data) {
            R = 1;
        }
        int length = Math.max(L, R);
        max = Math.max(max, length);
        return length;
    }

    public static int longestConsecutive(Node root) {
        return dfs(root, null, 0);
    }

    private static int dfs(Node p, Node parent, int length) {
        if (p == null) return length;
        length = (parent != null && p.data== parent.data + 1) ? length + 1 : 1;
        return Math.max(length, Math.max(dfs(p.left, p, length),
                dfs(p.right, p, length)));
    }
}
