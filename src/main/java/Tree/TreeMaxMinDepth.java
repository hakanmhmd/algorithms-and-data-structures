package Tree;

/**
 * Max and min depth of the tree
 */
public class TreeMaxMinDepth {
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

        System.out.println(maxDepth(tree.root));
        System.out.println(minDepth(tree.root));
    }

    private static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1; //leaf node

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(root.left != null) {
            left = minDepth(root.left);
        }
        if(root.right != null){
            right = minDepth(root.right);
        }

        return Math.min(left, right) + 1;

    }

    private static int maxDepth(TreeNode root) {
        if(root == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
