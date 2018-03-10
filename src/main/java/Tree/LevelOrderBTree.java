package Tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class LevelOrderBTree {
    static class Node {
        int key;
        Node right;
        Node left;

        public Node(int data){
            this.key = data;
            right = null;
            left = null;
        }
    }

    static void getLevelOrder(Node root, int level, TreeMap<Integer, ArrayList<Integer>> m){
        if(root == null) return;

        ArrayList<Integer> list = m.get(level);

        if(list == null){
            list = new ArrayList<>();
            list.add(root.key);
        } else {
            list.add(root.key);
        }

        m.put(level, list);

        getLevelOrder(root.left, level+1, m);
        getLevelOrder(root.right, level+1, m);
    }

    /*

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode t = queue.remove();

            if(t.left != null) nextLevel.add(t.left);
            if(t.right != null) nextLevel.add(t.right);
            temp.add(t.val);
            if(queue.isEmpty()){
                queue = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
                result.add(temp);
                temp = new ArrayList<>();
            }
        }

        return result;
    }
     */

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Level Order traversal is");
        printLevelOrder(root);
    }

    private static void printLevelOrder(Node root) {
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int rootLevel = 0;
        getLevelOrder(root, rootLevel, m);

        for(Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
