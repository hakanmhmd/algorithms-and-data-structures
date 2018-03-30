package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function to connect all the adjacent nodes at the same level in a binary tree.
 *
 * Output Tree
 *     A--->NULL
 *    / \
 *   B-->C-->NULL
 *  / \   \
 * D-->E-->F-->NULL
 */
public class ConnectNodesAtSameLevel {
    static class Node {
        int data;
        Node left, right, nextRight;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        root.right.left = new Node(15);

        connectNodes(root);
    }

    private static void connectNodes(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node p = q.poll();
            if(p!=null){
                p.nextRight = q.peek();
                if(p.left!=null){
                    q.offer(p.left);
                }
                if(p.right!=null){
                    q.offer(p.right);
                }
            }
            else {
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
    }
}
