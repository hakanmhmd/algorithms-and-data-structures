package Tree;

/**
 * Created by hakanmehmed on 06/11/2017.
 */
public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int item){
        this.key = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return key+"";
    }
}
