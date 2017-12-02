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
        printVerticalOrder(root);
    }

    private static void printVerticalOrder(Node root) {
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        int rootLevel = 0;
        getLevelOrder(root, rootLevel, m);

        for(Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
