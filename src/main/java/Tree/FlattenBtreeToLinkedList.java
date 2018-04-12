package Tree;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBtreeToLinkedList {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);

        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        TreeNode root = tree.root;
        print(root);
        System.out.println();
        flatten(root);
        System.out.println();
        print(root);
    }

    private static void print(TreeNode root) {
        if(root == null) return;
        print(root.left);
        System.out.print(root.key + " ");
        print(root.right);
    }

    private static void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while(p!=null || !stack.isEmpty()){
            if(p.right != null){
                stack.push(p.right);
            }

            if(p.left != null){
                p.right = p.left;
                p.left = null;
            } else if(!stack.isEmpty()){
                TreeNode temp = stack.pop();
                p.right = temp;
            }

            p = p.right;
        }
    }
}
