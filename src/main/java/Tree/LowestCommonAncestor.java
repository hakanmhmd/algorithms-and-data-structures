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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        if(left == null && right == null) return null;

        return left == null ? right : left;
    }
}

/*
Hackerrank:

static Node lca(Node root,int v1,int v2)
{
    Node current = root;
    ArrayList<Node> ancestorsOne = new ArrayList<>();
    while(true){
        if(current != null){
            ancestorsOne.add(current);
            if(current.data > v1){
                current = current.left;
            } else if(current.data < v1){
                current = current.right;
            } else {
                break;
            }
        } else {
            break;
        }
    }

    current = root;
    ArrayList<Node> ancestorsTwo = new ArrayList<>();
    while(true){
        if(current != null){
            ancestorsTwo.add(current);
            if(current.data > v2){
                current = current.left;
            } else if(current.data < v2){
                current = current.right;
            } else {
                break;
            }
        } else {
            break;
        }
    }



    Node lca = null;

    int l = ancestorsOne.size() < ancestorsTwo.size() ? ancestorsOne.size() : ancestorsTwo.size();
    for(int i=0; i<l; i++){
        if(ancestorsOne.get(i) == ancestorsTwo.get(i)){
            lca = ancestorsOne.get(i);
        } else {
            break;
        }
    }
    return lca;
}
 */
