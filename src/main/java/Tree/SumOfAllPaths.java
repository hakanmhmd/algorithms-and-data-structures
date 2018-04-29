package Tree;

/**
 * Given a binary tree, where every node value is a Digit from 1-9 .Find the sum of all the numbers which are
 * formed from root to leaf paths.
 */
public class SumOfAllPaths {
     static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.right.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.left.right.right = new Node(4);
        root.left.right.left = new Node(7);

        System.out.print("Sum of all paths is " +
                treePathsSum(root, 0));
    }

    private static int treePathsSum(Node root, int curr) {
        if(root == null){
            return 0;
        }



        curr = (curr * 10) + root.data;
        if(root.left == null && root.right == null){
            return curr;
        }
        int sum = 0;
        sum += treePathsSum(root.left, curr);
        sum += treePathsSum(root.right, curr);

        return sum;

    }
}
