package Tree;

import java.util.ArrayList;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */
public class AllRootToLeafPaths {
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
        root.right = new Node(30);
        root.left.right = new Node(6);


        System.out.println(allPaths(root));
    }

    private static ArrayList<ArrayList<Integer>> allPaths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(res, root, new ArrayList<Integer>());
        return res;
    }

    private static void helper(ArrayList<ArrayList<Integer>> res, Node root, ArrayList<Integer> temp) {
        temp.add(root.data);

        if(root.left == null && root.right == null){
            res.add((ArrayList<Integer>) temp.clone());
            return;
        }

        if(root.left != null){
            helper(res, root.left, temp);
            temp.remove(temp.size()-1);
        }

        if(root.right != null){
            helper(res, root.right, temp);
            temp.remove(temp.size()-1);
        }

    }
}
