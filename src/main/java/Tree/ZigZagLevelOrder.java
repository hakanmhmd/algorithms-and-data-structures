package Tree;


import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by hakanmehmed on 03/03/2018.
 */
public class ZigZagLevelOrder {
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
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Zigzag Order traversal is");
        List<List<Integer>> lists = printZigZagOrder(root);
        lists.forEach(System.out::println);

        List<List<Integer>> lists2 = printZigZagOrder2(root);
        lists2.forEach(System.out::println);
    }

    // can be achieved using two stacks - even stack and odd stack for the levels
    private static List<List<Integer>> printZigZagOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> nextLevelQueue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> temp = new ArrayList<>();
        boolean rightToLeft = true;
        while(!queue.isEmpty()){
            Node n = queue.remove();
            temp.add(n.key);

            if(rightToLeft) {
                if (n.left != null) nextLevelQueue.addFirst(n.left);
                if (n.right != null) nextLevelQueue.addFirst(n.right);
            } else {
                if (n.right != null) nextLevelQueue.addFirst(n.right);
                if (n.left != null) nextLevelQueue.addFirst(n.left);
            }

            if(queue.isEmpty()){
                result.add(temp);
                queue = nextLevelQueue;
                temp = new ArrayList<>();
                nextLevelQueue = new LinkedList<>();
                rightToLeft = !rightToLeft;
            }
        }

        return result;
    }

    private static List<List<Integer>> printZigZagOrder2(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Stack<Node> stack1 = new Stack<>(); //left to right
        Stack<Node> stack2 = new Stack<>(); // right to left

        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(stack1.isEmpty()){
                while(!stack2.isEmpty()){
                    Node n = stack2.pop();
                    list.add(n.key);
                    if(n.right != null) stack1.push(n.right);
                    if(n.left != null) stack1.push(n.left);
                }
            } else {
                while(!stack1.isEmpty()){
                    Node n = stack1.pop();
                    list.add(n.key);
                    if(n.left != null) stack2.push(n.left);
                    if(n.right != null) stack2.push(n.right);
                }
            }
            result.add(list);
        }
        return result;

    }
}
