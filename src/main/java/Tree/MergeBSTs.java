package Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form. The expected time complexity
 * is O(m+n) where m is the number of nodes in first tree and n is the number of nodes in second tree.
 * Maximum allowed auxiliary space is O(height of the first tree + height of the second tree).
 */
public class MergeBSTs {
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(8);
        root1.left = new Node(2);
        root1.right = new Node(10);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);

        Node root2 = new Node(5);
        root2.left = new Node(4);

        System.out.println(mergeBsts(root1, root2));
    }

    private static ArrayList<Integer> mergeBsts(Node root1, Node root2) {
        Node curr1 = root1;
        Node curr2 = root2;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        ArrayList<Integer> res = new ArrayList<>();

        while(!s1.isEmpty() || !s2.isEmpty() || curr1 != null || curr2 != null){
            if(curr1 != null || curr2 != null){
                if(curr1 != null){
                    s1.push(curr1);
                    curr1 = curr1.left;
                }
                if(curr2 != null){
                    s2.push(curr2);
                    curr2 = curr2.left;
                }
            } else {
                if(s1.isEmpty()){
                    while(!s2.isEmpty()){
                        Node t2 = s2.pop();
                        t2.left = null;
                        inorder(t2, res);
                    }
                    return res;
                }

                if(s2.isEmpty()){
                    while(!s1.isEmpty()){
                        Node t1 = s1.pop();
                        t1.left = null;
                        inorder(t1, res);
                    }
                    return res;
                }
                Node t1 = s1.pop();
                Node t2 = s2.pop();
                if(t1.data < t2.data) {
                    res.add(t1.data);
                    curr1 = t1.right;
                    s2.push(t2);
                    curr2 = null;
                } else {
                    res.add(t2.data);
                    curr2 = t2.right;
                    s1.push(t1);
                    curr1 = null;
                }
            }
        }

        return res;
    }

    private static void inorder(Node node, ArrayList<Integer> res) {
        if(node != null){
            inorder(node.left, res);
            res.add(node.data);
            inorder(node.right, res);
        }
    }
}
