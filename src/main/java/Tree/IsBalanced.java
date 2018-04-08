package Tree;

/**
 * Is tree height balanced - diff between subtrees is at most 1
 */
public class IsBalanced {
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
        root.left.left.left = new Node(8);
        root.right.right.right = new Node(9);

        System.out.println(isBalanced(root));
    }

    private static boolean isBalanced(Node root) {
        if(checkDepth(root) == -1) return false;
        return true;
    }

    private static int checkDepth(Node root) {
        if(root == null) return 0;
        int leftDepth = checkDepth(root.left);
        if(leftDepth == -1) return -1;
        int rightDepth = checkDepth(root.right);
        if(rightDepth == -1) return -1;

        if(Math.abs(leftDepth - rightDepth) > 1) return -1;
        return Math.max(leftDepth, rightDepth) + 1;

    }

}
