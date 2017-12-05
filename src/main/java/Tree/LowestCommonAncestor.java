package Tree;

import java.util.Stack;

/**
 * Given two nodes in a tree, find a node that is the first ancestor to both of them
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(75);
        tree.insert(60);
        tree.insert(25);
        tree.insert(35);

        TreeNode lca = findLowestCommonAncestor(tree.root, 25, 35);
        System.out.println(lca.key);
    }

    private static TreeNode findLowestCommonAncestor(TreeNode root, int x, int y) {
        Stack<TreeNode> ancestorsOfX = pathTo(root, x);
        Stack<TreeNode> ancestorOfY = pathTo(root, y);

        TreeNode lca = null;
        while(!ancestorOfY.isEmpty() && !ancestorsOfX.isEmpty()){
            TreeNode xPop = ancestorsOfX.pop();
            TreeNode yPop = ancestorOfY.pop();

            if(xPop.key == yPop.key){
                lca = xPop;
            } else {
                break;
            }
        }
        return lca;
    }

    private static Stack<TreeNode> pathTo(TreeNode root, int i) {
        if(root == null) return null;
        if (root.key == i){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            return stack;
        }
        Stack<TreeNode> leftPath = pathTo(root.left, i);
        if(leftPath != null){
            leftPath.add(root);
            return leftPath;
        }

        Stack<TreeNode> rightPath = pathTo(root.right, i);
        if(rightPath != null){
            rightPath.add(root);
            return rightPath;
        }

        return null;
    }
}
