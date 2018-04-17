package Tree;

import javafx.util.Pair;

import java.util.Stack;

/**
 * A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.
 */
public class SuperBalancedTree {
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
        Node root = new Node(1);
        root.left = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(1);
        root.right = new Node(1);
        root.right.left = new Node(1);
        root.right.left.right = new Node(1);
        root.right.right = new Node(1);
        root.right.right.left = new Node(1);
        root.right.right.right = new Node(1);
        root.right.right.right.left = new Node(1);

        System.out.println(isSuperBalanced(root, 1));
        System.out.println(isBalanced(root));
    }

    private static int isSuperBalanced(Node root, int depth) {
        if(root.left == null && root.right == null){
            return depth;
        }

        int left = 0;
        if(root.left != null) left = isSuperBalanced(root.left, depth+1);
        int right = 0;
        if(root.right != null) right = isSuperBalanced(root.right, depth+1);

        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left, right);
    }

    private static boolean isBalanced(Node tree) {
        if (tree == null) { return true; }

        Stack<Pair<Node, Integer>> nodes = new Stack<>();
        nodes.add(new Pair<>(tree, 1));

        int depth = 0;
        int firstDepth = -1;
        int secondDepth = -1;
        while (!nodes.isEmpty()) {
            Pair<Node, Integer> node = nodes.pop();
            depth = node.getValue();
            if (node.getKey().left == null && node.getKey().right == null) {
                if (firstDepth == -1) {
                    firstDepth = depth;
                } else if (depth != firstDepth) {
                    if (secondDepth == -1) {
                        secondDepth = depth;
                        if (Math.abs(secondDepth - firstDepth) > 1) {
                            return false;
                        }
                    } else if (depth != secondDepth) {
                        return false;
                    }
                }
            } else {
                if (node.getKey().left != null) {
                    nodes.push(new Pair<>(node.getKey().left, depth + 1));
                }
                if (node.getKey().right != null) {
                    nodes.push(new Pair<>(node.getKey().right, depth + 1));
                }
            }
        }

        return true;
    }
}
