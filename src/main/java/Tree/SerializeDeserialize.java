package Tree;

import com.sun.tools.javac.util.List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

/**
 * Created by hakanmehmed on 10/03/2018.
 */
public class SerializeDeserialize {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(75);
        tree.insert(60);
        tree.insert(25);
        tree.insert(35);

        System.out.println(serialize(tree.root));
        System.out.println(serialize2(tree.root));
    }

    public static String serialize2(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (n != null) {
                sb.append(n.key + ",");
                q.add(n.left);
                q.add(n.right);
            } else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public static String serialize(TreeNode root) {
        if (root == null) return "";
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node != null) {
                sb.append(node.key + ",");
                s.push(node.right);
                s.push(node.left);

            } else {
                sb.append("null,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public static TreeNode deserialize2(String data) {
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int index = 1;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node != null) {
                String left = nodes[index++];
                String right = nodes[index++];
                node.left = null;
                node.right = null;
                if (!left.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(left));
                }
                if (!right.equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(right));
                }
                q.add(node.left);
                q.add(node.right);
            }
        }

        return root;
    }


    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] split = data.split(",");
        List<String> nodes = (List<String>) Arrays.asList(split);
        return helper(nodes.iterator());

    }

    public static TreeNode helper(Iterator<String> i) {
        String next = i.next();
        if (next.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(next));
        root.left = helper(i);
        root.right = helper(i);

        return root;
    }

}
