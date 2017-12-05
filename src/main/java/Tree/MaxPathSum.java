package Tree;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree. For example, given the below binary tree
 */
public class MaxPathSum {
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


        int sum = maxPathSum(root);
        System.out.println(sum);
    }

    public static int maxPathSum(Node root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public static int calculateSum(Node root, int[] max) {
        if (root == null)
            return 0;

        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.data, Math.max(root.data + left, root.data + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.data + right));

        return current;
    }
}
