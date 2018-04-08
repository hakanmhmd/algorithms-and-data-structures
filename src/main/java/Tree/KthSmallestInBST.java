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

    // 4 5 6 10 14 40 45 50
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

        k = 3;
        System.out.println(findKthLargestElement(root, k));
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

    private static int findKthLargestElement(Node root, int k) {
        Stack<Node> s = new Stack<>();
        Node current = root;

        while(!s.isEmpty() || current != null){
            if(current != null){
                s.push(current);
                current = current.right;
            } else {
                Node pop = s.pop();
                k--;
                if(k == 0) return pop.key;
                current = pop.left;
            }
        }
        return -1;
    }

    /*
    find(Node root, int n, int[] count){
        if(root == null) return null;
        Node node = null;

        node = find(root.right, n, count);

        if(node == null){
            count[0] += 1;
            if(count[0] == n) node = root;
        }

        if(node == null){
            find(root.left, n, count);
        }

        return node;
    }
     */
}
