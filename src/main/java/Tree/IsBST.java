package Tree;

import java.util.Stack;

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

    static Node root;

    static Node prev = null;

    public static void main(String args[])
    {
        IsBST tree = new IsBST();
        tree.root = new Node(4);
        tree.root.left = new Node(4);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

        if (tree.isBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    public static boolean isBST() {
        if(root == null) return true;
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private static boolean isBSTUtil(Node root, int minValue, int maxValue) {
        if(root == null) return true;
        if(root.data < minValue || root.data > maxValue){
            return false;
        }

        return (isBSTUtil(root.left, minValue, root.data) && isBSTUtil(root.right, root.data, maxValue));
    }

    // Using in order traversal and no additional DS
    private static boolean isBST(Node node) {
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

        public boolean isValidBST(Node root){
        if (root == null){
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        Node pre = null;
        Node cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                Node p = stack.pop();
                if (pre != null && p.data <= pre.data){
                    return false;
                }
                pre = p;
                cur = p.right;
            }
        }
        return true;

    }
}
