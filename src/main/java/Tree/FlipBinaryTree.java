package Tree;

/**
 * Given a binary tree, the task is to flip the binary tree towards right direction that is clockwise.

 In the flip operation, left most node becomes the root of flipped tree and its parent become its right child
 and the right sibling become its left child and same should be done for all left most nodes recursively.
 */
public class FlipBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        print(tree);
        Node root = flip(tree);
        System.out.println();
        print(root);

    }

    private static void print(Node tree) {
        if(tree == null) return;
        print(tree.left);
        System.out.print(tree.data + " ");
        print(tree.right);
    }

    private static Node flip(Node root) {
        Node current = root;
        Node currentParentRight = null;
        Node currentParent = null;

        Node newRoot = null;
        while(current != null) {
            Node nextParentRight = current.right;
            Node nextParent = current.left;

            current.right = currentParent;
            current.left = currentParentRight;

            newRoot = current;
            currentParent = current;
            currentParentRight = nextParentRight;
            current = nextParent;
        }

        return newRoot;
    }
}
