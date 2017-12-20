package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 *
 *
 Sample input:
 11
 2 3
 4 -1
 5 -1
 6 -1
 7 8
 -1 9
 -1 -1
 10 11
 -1 -1
 -1 -1
 -1 -1
 2
 2
 4
 */

public class NodeSwaps {
    static class Node {
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }


    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //  build the tree
        Node root = new Node(1);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int n = in.nextInt();
        while(!q.isEmpty()){
            Node node = q.remove();
            if(node == null) continue;
            Node l = null;
            Node r = null;
            int lVal = in.nextInt();
            int rVal = in.nextInt();
            if(lVal != -1){
                l = new Node(lVal);
            }
            if(rVal != -1){
                r = new Node(rVal);
            }

            node.left = l;
            node.right = r;
            q.add(l);
            q.add(r);
        }

        // do the swaps
        int swaps = in.nextInt();
        for(int i=0; i<swaps; i++){
            int k = in.nextInt();
            doSwaps(root, 1, k);
            inOrder(root);
            System.out.println();
        }
    }

    static void doSwaps(Node root, int level, int k){
        if(root == null) return;
        if(level % k == 0){
            Node temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        doSwaps(root.left, level+1, k);
        doSwaps(root.right, level+1, k);
    }

    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
