package Tree;

import java.util.Stack;

/**
 * Created by hakanmehmed on 06/11/2017.
 */
public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }


    /*
            5
         1      7
           4      8
                    20
                   15
     */

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(1);
        tree.insert(7);
        tree.insert(8);
        tree.insert(4);
        tree.insert(20);
        tree.insert(15);

        preorderTraversal(tree.root);
        System.out.println();
        preorderTraversalIter(tree.root);
        System.out.println();
        System.out.println();
        inorderTraversal(tree.root);
        System.out.println();
        inorderTraversalIter(tree.root);
        System.out.println();
        System.out.println();
        postorderTraversal(tree.root);
        System.out.println();
        postorderTraversalIter(tree.root);
        System.out.println();
        postorderTraversalIterOneStack(tree.root);
    }

    private static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.key + " ");
    }

    private static void postorderTraversalIter(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> temp = new Stack<>();
        Stack<TreeNode> all = new Stack<>();
        temp.push(root);

        while (!temp.isEmpty()) {
            TreeNode pop = temp.pop();
            all.push(pop);

            if (pop.left != null) temp.push(pop.left);
            if (pop.right != null) temp.push(pop.right);
        }

        while (!all.isEmpty()) {
            System.out.print(all.pop().key + " ");
        }

    }

    private static void postorderTraversalIterOneStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode currentNode = root;
        s.push(root);

        while (!s.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode temp = s.peek().right;
                if (temp == null) { // if it has right child
                    temp = s.pop();
                    System.out.print(temp.key + " ");
                    while (!s.isEmpty() && temp == s.peek().right) {
                        temp = s.pop();
                        System.out.print(temp.key + " ");
                    }
                } else {
                    currentNode = temp;
                }

            }
        }


    }

    private static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }

    private static void inorderTraversalIter(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode currentNode = root;

        while (!s.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            }

            TreeNode current = s.pop();
            System.out.print(current.key + " ");
            currentNode = current.right;

        }

    }

    private static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private static void preorderTraversalIter(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode current = s.pop();
            System.out.print(current.key + " ");

            if (current.right != null) s.push(current.right);
            if (current.left != null) s.push(current.left);
        }

    }


}
