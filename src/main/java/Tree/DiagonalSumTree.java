package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the sum of diagonals in a binary tree
 */
public class DiagonalSumTree {
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

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(40);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(14);
        root.right.right = new Node(45);
        root.right.right.right = new Node(50);

        HashMap<Integer, Integer> map = new HashMap<>(); // diagonal to sum
        diagSum(root, 0, map);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    private static void diagSum(Node root, int currDiag, HashMap<Integer, Integer> map) {
        if(root == null) return;

        diagSum(root.left, currDiag+1, map);

        int currSum = 0;
        if(map.get(currDiag) != null){
            currSum = map.get(currDiag);
        }
        currSum += root.key;
        map.put(currDiag, currSum);

        diagSum(root.right, currDiag, map);
    }
}
