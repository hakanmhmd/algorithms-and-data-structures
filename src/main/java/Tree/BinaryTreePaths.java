package Tree;

import java.util.*;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(40);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(114);
        root.right.right = new Node(45);
        root.right.right.right = new Node(50);

        System.out.println(binaryTreePaths(root));
    }
    public static List<List<Integer>> binaryTreePaths(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(res, root, new ArrayList<Integer>());
        return res;
    }

    private void searchBT(Node root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.data);
        if (root.left != null) searchBT(root.left, path + root.data + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.data + "->", answer);
    }

    private static void helper(List<List<Integer>> res, Node root, ArrayList<Integer> temp) {
        temp.add(root.data);

        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(root.left != null){
            helper(res, root.left, temp);
            temp.remove(temp.size()-1);
        }

        if(root.right != null){
            helper(res, root.right, temp);
            temp.remove(temp.size()-1);
        }

    }

    //bfs
    public List<String> binaryTreePathsBFS(Node root) {
        List<String> list=new ArrayList<String>();
        Queue<Node> qNode=new LinkedList<Node>();
        Queue<String> qStr=new LinkedList<String>();

        if (root==null) return list;
        qNode.add(root);
        qStr.add("");
        while(!qNode.isEmpty()) {
            Node curNode=qNode.remove();
            String curStr=qStr.remove();

            if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.data);
            if (curNode.left!=null) {
                qNode.add(curNode.left);
                qStr.add(curStr+curNode.data+"->");
            }
            if (curNode.right!=null) {
                qNode.add(curNode.right);
                qStr.add(curStr+curNode.data+"->");
            }
        }
        return list;
    }

    //dfs
    public List<String> binaryTreePathsDFS(Node root) {
        List<String> list=new ArrayList<String>();
        Stack<Node> sNode=new Stack<Node>();
        Stack<String> sStr=new Stack<String>();

        if(root==null) return list;
        sNode.push(root);
        sStr.push("");
        while(!sNode.isEmpty()) {
            Node curNode=sNode.pop();
            String curStr=sStr.pop();

            if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.data);
            if(curNode.left!=null) {
                sNode.push(curNode.left);
                sStr.push(curStr+curNode.data+"->");
            }
            if(curNode.right!=null) {
                sNode.push(curNode.right);
                sStr.push(curStr+curNode.data+"->");
            }
        }
        return list;
    }
}
