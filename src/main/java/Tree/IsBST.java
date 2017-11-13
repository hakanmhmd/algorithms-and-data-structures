package Tree;

/**
 * Given a binary tree determine if it is a BST
 */
public class IsBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    Node prev = null;

    public static void main(String args[])
    {
        IsBST tree = new IsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

        if (tree.isBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    private boolean isBST() {
        if(root == null) return true;
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node root, int minValue, int maxValue) {
        if(root == null) return true;
        if(root.data < minValue || root.data > maxValue){
            return false;
        }

        return (isBSTUtil(root.left, minValue, root.data-1) && isBSTUtil(root.right, root.data+1, maxValue));
    }

    // Using in order traversal and no additional DS
    private boolean isBST(Node node) {
        if(node != null){
            if(!isBST(node.left)){
                return false;
            }

            if(prev != null && node.data < prev.data){
                return false;
            }
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
}
