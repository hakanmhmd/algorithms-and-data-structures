package Tree;

/**
 * Created by hakanmehmed on 14/03/2018.
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 */
public class LongestUnivaluePath {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(4);
        root.right.left = new Node(5);

        System.out.println(longestUnivaluePath(root));
    }

    static private int ans;

    public static int longestUnivaluePath(Node root) {
        ans = 0;
        traverse(root);
        return ans;
    }
    public static int traverse(Node node) {
        if (node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.data == node.data) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.data == node.data) {
            arrowRight += right + 1;
        }

        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
