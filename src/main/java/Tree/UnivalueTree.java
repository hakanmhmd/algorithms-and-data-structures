package Tree;

/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 */
public class UnivalueTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.right = new Node(0);
        root.right.left = new Node(1);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(1);

        System.out.println(countUnivalueTrees(root));
    }

    private static int countUnivalueTrees(Node root) {
        if(root == null) return 0;
        if(isLeft(root)) return 1;
        int count = 0;
        count += countUnivalueTrees(root.left);
        count += countUnivalueTrees(root.right);

        boolean sameAsLeft = root.left == null || root.left.data == root.data;
        boolean sameAsRight = root.right == null || root.right.data == root.data;
        if(sameAsLeft && sameAsRight) count += 1;

        return count;
    }

    private static boolean isLeft(Node root) {
        return root.left == null && root.right == null;
    }
}
