package Tree;

import java.util.Stack;

/**
 * Created by hakanmehmed on 11/03/2018.
 */
public class KthSmallestInBST {
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

        int k = 5;
        System.out.println(findKthSmallestElement(root, k));
    }

    private static int findKthSmallestElement(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        int result = 0;
        Node current = root;

        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                Node p = stack.pop();
                k--;
                if(k==0) result = p.key;
                current = p.right;
            }
        }

        return result;
    }
}
