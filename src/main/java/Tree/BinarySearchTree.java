package Tree;

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
        inorderTraversal(tree.root);
        System.out.println();
        postorderTraversal(tree.root);
    }

    private static void postorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        System.out.print(root.key + " ");
    }

    private static void inorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        preorderTraversal(root.left);
        System.out.print(root.key + " ");
        preorderTraversal(root.right);
    }

    private static void preorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.key + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


}
