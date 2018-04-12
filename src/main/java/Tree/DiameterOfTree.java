package Tree;

/**
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.
 */
public class DiameterOfTree {
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

        System.out.println(diameter(root));
    }

    private static int diameter(Node root) {
        if(root == null) return 0;

        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.max(leftH + rightH + 1, Math.max(diameter(root.left), diameter(root.right)));
    }

    static int height(Node node) {
        /* base case tree is empty */
        if (node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
