package Tree;

import java.util.Stack;

/**
 * Created by hakanmehmed on 02/12/2017.
 */
public class FlattenBtreeToLinkedList {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        TreeNode root = tree.root;
        flatten(root);
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
