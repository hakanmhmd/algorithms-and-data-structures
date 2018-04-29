package Tree;

import java.util.HashSet;

/**
 * Given a Binary Tree, check whether the Binary tree contains a duplicate sub-tree of size 2 or more.
 Note : Two same leaf nodes are not considered as subtree size of a leaf node is one.
 */
public class DuplicateSubtreesOfSize2OrMore {
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
        root1.left = new Node(5);
        root1.right = new Node(6);
        root1.right.right = new Node(5);
        root1.right.right.left = new Node(1);
        root1.right.right.right = new Node(3);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);

        HashSet<String> subtrees = new HashSet<>();
        System.out.println(dupSub(root1, subtrees));
    }

    private static String dupSub(Node node, HashSet<String> subtrees) {
        String s = "";
        if(node == null){
            return s + "#";
        }

        String left = dupSub(node.left, subtrees);
        if(left.equals("")) return s;
        String right = dupSub(node.right, subtrees);
        if(right.equals("")) return s;

        s = s + left + node.data + right;
        if(s.length() > 3 && subtrees.contains(s)){
            return "";
        }
        subtrees.add(s);
        return s;
    }
}
