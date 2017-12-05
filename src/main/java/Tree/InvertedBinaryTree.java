package Tree;

/**
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert(mirror) a binary tree on a whiteboard so f**k off.
 */
public class InvertedBinaryTree {
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

        Node newRoot = invertBTree(root);

    }

    private static Node invertBTree(Node root) {
        if(root != null){
            helper(root);
        }
        return root;
    }

    private static void helper(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null){
            helper(root.left);
        }
        if(root.right != null){
            helper(root.right);
        }
    }
}
