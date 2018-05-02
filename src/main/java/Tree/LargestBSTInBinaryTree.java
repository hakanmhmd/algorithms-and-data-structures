package Tree;

/**
 * Given a binary tree, write a program to find the size of largest binary search tree(BST) in it
 * O(1) space
 *
 * Another method: inorder traversal and find longest increasing subarray with O(n) space
 */
public class LargestBSTInBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int x)
        {
            this.data = x;
        }
    }

    static class MinMax{
        int min;
        int max;
        boolean isBST;
        int size ;

        MinMax(){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1   = new TreeNode(6);
        TreeNode n2   = new TreeNode(12);
        TreeNode n3   = new TreeNode(7);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(9);
        TreeNode n6   = new TreeNode(14);
        TreeNode n7   = new TreeNode(13);
        TreeNode n8   = new TreeNode(16);

        root.left  = n1;
        root.right = n2;

        n1.left  = n3;
        n1.right = n4;

        n2.left  = n5;
        n2.right = n6;

        n6.left = n7;
        n6.right = n8;

        System.out.println(sizeOfLargestBST(root));
    }

    // post order traversal
    private static int sizeOfLargestBST(TreeNode root) {
        MinMax mm = largest(root);
        return mm.size;
    }

    private static MinMax largest(TreeNode root) {
        if(root == null) return new MinMax();

        MinMax left = largest(root.left);
        MinMax right = largest(root.right);

        MinMax curr = new MinMax();

        if(!left.isBST || !right.isBST || root.data < left.max || root.data > right.min){
            curr.isBST = false;
            curr.size = Math.max(left.size, right.size);
            return curr;
        }

        curr.isBST = true;
        curr.size = left.size + right.size + 1;
        curr.min = root.left != null ? left.min : root.data;
        curr.max = root.right != null ? right.max : root.data;

        return curr;
    }
}
