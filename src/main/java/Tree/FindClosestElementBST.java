package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary search tree and a target node K. The task is to find the node with
 * minimum absolute difference with given target value K.
 */
public class FindClosestElementBST {
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

        int k = 8;

        System.out.println(closestValue(root, k));

    }

    public static int closestValue(Node root, double target) {
        double min=Double.MAX_VALUE;
        int result = root.key;

        while(root!=null){
            if(target>root.key){
                double diff = Math.abs(root.key-target);
                if(diff<min){
                    min = diff;
                    result = root.key;
                }
                root = root.right;
            }else if(target<root.key){
                double diff = Math.abs(root.key-target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.key;
                }
                root = root.left;
            }else{
                return root.key;
            }
        }

        return result;
    }

    //Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
    // One solution is priority queue - The time complexity would be O(k + (n - k) logk).

    // Linear solution
    public List<Integer> closestKValues(Node root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Integer> precedessor = new Stack<>();
        Stack<Integer> successor = new Stack<>();

        getPredecessor(root, target, precedessor);
        getSuccessor(root, target, successor);

        for (int i = 0; i < k; i++) {
            if (precedessor.isEmpty()) {
                result.add(successor.pop());
            } else if (successor.isEmpty()) {
                result.add(precedessor.pop());
            } else if (Math.abs((double) precedessor.peek() - target) < Math.abs((double) successor.peek() - target)) {
                result.add(precedessor.pop());
            } else {
                result.add(successor.pop());
            }
        }

        return result;
    }

    private void getPredecessor(Node root, double target, Stack<Integer> precedessor) {
        if (root == null) {
            return;
        }

        getPredecessor(root.left, target, precedessor);

        if (root.key > target) {
            return;
        }

        precedessor.push(root.key);

        getPredecessor(root.right, target, precedessor);
    }

    private void getSuccessor(Node root, double target, Stack<Integer> successor) {
        if (root == null) {
            return;
        }

        getSuccessor(root.right, target, successor);

        if (root.key <= target) {
            return;
        }

        successor.push(root.key);

        getSuccessor(root.left, target, successor);
    }
}
