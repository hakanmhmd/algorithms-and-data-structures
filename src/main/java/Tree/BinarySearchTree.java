package Tree;

import java.util.Stack;

/**
 * Created by hakanmehmed on 06/11/2017.
 */
public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int key){
        root = insert(root, key);
    }

    private TreeNode insert(TreeNode root, int key) {
        if(root == null){
            root = new TreeNode(key);
            return root;
        }

        if(key < root.key){
            root.left = insert(root.left, key);
        } else if(key > root.key){
            root.right = insert(root.right, key);
        }

        return root;
    }



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
    }

    private static void postorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.key + " ");
    }

    private static void postorderTraversalIter(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode temp = s1.pop();
            s2.push(temp);

            if(temp.left != null) s1.push(temp.left);
            if(temp.right != null) s1.push(temp.right);
        }

        while(!s2.isEmpty()){
            System.out.print(s2.pop().key + " ");
        }

    }

    private static void inorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }

    private static void inorderTraversalIter(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode currentNode=root;

        while(!s.isEmpty() || currentNode != null){
            if(currentNode != null){
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode current = s.pop();
                System.out.print(current.key + " ");
                currentNode = current.right;
            }
        }

    }

    private static void preorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.key + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private static void preorderTraversalIter(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            TreeNode current = s.pop();
            System.out.print(current.key + " ");

            if(current.right != null) s.push(current.right);
            if(current.left != null) s.push(current.left);
        }

    }


}
