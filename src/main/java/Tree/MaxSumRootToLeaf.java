package Tree;

/**
 * Created by hakanmehmed on 04/12/2017.
 */
public class MaxSumRootToLeaf {
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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(40);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(114);
        root.right.right = new Node(45);
        root.right.right.right = new Node(50);

        int sum = maxSumPath(root);
        System.out.println(sum);
    }

    private static int maxSumPath(Node root) {
        if(root == null) return 0;

        int max = Integer.MIN_VALUE;
        return maxSum(root, max, 0);
    }

    private static int maxSum(Node root, int max, int current) {
        if(root == null){
            return max;
        }
        current = current + root.data;

        if(root.left == null && root.right == null){
            if(current > max){
                max = current;
            }
        } else {
            max = Math.max(maxSum(root.left, max, current), maxSum(root.right, max, current));
        }

        return max;
    }
}
