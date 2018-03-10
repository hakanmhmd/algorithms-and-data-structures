package Tree;

import java.util.ArrayList;

/**
 * Given a tree and a sum, return true if there is a path from the root
 down to a leaf, such that adding up all the values along the path
 equals the given sum.

 Strategy: subtract the node value from the sum when recurring down,
 and check to see if the sum is 0 when you run out of tree.
 */
public class PathsWithSum {
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    Node root;

    ArrayList<ArrayList<Integer>> hasPathSum(Node node, int sum)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(node == null) return result;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.data);
        hasPathSumHelper(node, sum-node.data, result, list);
        return result;
    }

    private void hasPathSumHelper(Node node, int i, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if(node.left == null && node.right == null && i == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            result.add(temp);
        }

        if(node.left != null){
            list.add(node.left.data);
            hasPathSumHelper(node.left, i-node.left.data, result, list);
            list.remove(list.size()-1);
        }

        if(node.right != null){
            list.add(node.right.data);
            hasPathSumHelper(node.right, i-node.right.data, result, list);
            list.remove(list.size()-1);
        }
    }

    public static boolean hasPathSum2(Node root, int sum) {
        if(root == null) return false;

        return hasPathSumUtil(root, 0, sum);
    }

    private static boolean hasPathSumUtil(Node node, int currentSum, int sum){
        if(node != null){
            currentSum += node.data;
            if(currentSum == sum && node.left == null && node.right == null) return true;
            return hasPathSumUtil(node.left, currentSum, sum) || hasPathSumUtil(node.right, currentSum, sum);
        }
        return false;
    }


    public static void main(String args[])
    {
        int sum = 21;

        /* Constructed binary tree is
              10
             /  \
           8     9
          / \   /
         3   5 2
        */
        PathsWithSum tree = new PathsWithSum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        ArrayList<ArrayList<Integer>> arrayLists = tree.hasPathSum(tree.root, sum);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        System.out.println(hasPathSum2(tree.root, sum));

    }
}
