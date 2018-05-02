package Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. 
 * Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

 Left boundary is defined as the path from root to the left-most node. Right boundary is defined 
 as the path from root to the right-most node. If the root doesn't have left subtree or right 
 subtree, then the root itself is left boundary or right boundary. Note this definition only 
 applies to the input binary tree, and not applies to any subtrees.

 The left-most node is defined as a leaf node you could reach when you always firstly travel
 to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

 The right-most node is also defined by the same way with left and right exchanged.
 */
public class BoundaryOfBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int x)
        {
            this.data = x;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
        TreeNode n6   = new TreeNode(7);
        TreeNode n7   = new TreeNode(8);
        TreeNode n8   = new TreeNode(9);
        TreeNode n9   = new TreeNode(10);

        root.left  = n1;
        root.right = n2;

        n1.left  = n3;
        n1.right = n4;
        
        n4.left = n6;
        n4.right = n7;

        n2.left  = n5;

        n5.left = n8;
        n5.right = n9;

        System.out.println(boundary(root));
    }

    private static ArrayList<Integer> boundary(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        if(!isLeaf(root)){
            res.add(root.data);
        }
        TreeNode curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }

            if(curr.left != null){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        addLeaves(res, root);

        // right boundary in reverse order - use stack
        Stack<Integer> s = new Stack<>();
        curr = root.right;
        while(curr != null){
            if(!isLeaf(curr)){
                s.push(curr.data);
            }

            if(curr.right != null){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while(!s.isEmpty()){
            res.add(s.pop());
        }

        return res;
    }

    private static void addLeaves(ArrayList<Integer> res, TreeNode root) {
        if(isLeaf(root)){
            res.add(root.data);
        } else {
            if(root.left != null){
                addLeaves(res, root.left);
            }
            if(root.right != null){
                addLeaves(res, root.right);
            }
        }
    }

    private static boolean isLeaf(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return false;
    }
}
