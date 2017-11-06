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
}
