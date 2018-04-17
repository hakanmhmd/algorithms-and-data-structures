package Tree;

/**
 * Given the root of a binary search tree and 2 numbers min and max,
 * trim the tree such that all the numbers in the new tree are between min and max (inclusive)
 */
public class TrimBST {
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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(14);
        root.right.right = new Node(17);

        int min = 5;
        int max = 12;
        print(root);
        System.out.println();
        trim(root, min, max);
        print(root);
    }

    private static void print(Node root) {
        if(root == null) return;
        print(root.left);
        System.out.print(root.key + " ");
        print(root.right);
    }

    private static Node trim(Node root, int min, int max) {
        if(root == null) return root;

        root.left = trim(root.left, min, max);
        root.right = trim(root.right, min, max);

        if(root.key >= min && root.key <= max) return root;
        else if(root.key < min){
            return root.right;
        } else  {
            return root.left;
        }
    }
}
