package Tree;

/**
 * Given a binary tree, write a program to count the number of Single Valued Subtrees.
 * A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n).
 */
public class SingleValuedSubtrees {
    static class Node {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static int count = 0;
    public static void main(String args[]) {
           /*
                5
              /   \
            4      5
          /  \      \
         4    4      5
               \
                3
               / \
              3   3
              */
        Node tree = new Node(5);
        tree.left = new Node(4);
        tree.right = new Node(5);
        tree.left.left = new Node(4);
        tree.left.right = new Node(4);
        tree.left.right.right = new Node(3);
        tree.left.right.right.left = new Node(3);
        tree.left.right.right.right = new Node(3);
        tree.right.right = new Node(5);

        countSingle(tree);
        System.out.println(count);
    }

    private static boolean countSingle(Node root) {
        if(root == null) return true;

        boolean left = countSingle(root.left);
        boolean right = countSingle(root.right);

        if(!left || !right){
            return false;
        }

        if(root.left != null && root.left.data != root.data) return false;
        if(root.right != null && root.right.data != root.data) return false;
        count++;
        return true;
    }
}
