package Tree;

/**
 * Given a binary search tree and a target node K. The task is to find the node with
 * minimum absolute difference with given target value K.
 */
public class FindClosestElementBST {
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

        int k = 8;

        System.out.println(closestValue(root, k));

    }

    public static int closestValue(Node root, double target) {
        double min=Double.MAX_VALUE;
        int result = root.key;

        while(root!=null){
            if(target>root.key){
                double diff = Math.abs(root.key-target);
                if(diff<min){
                    min = diff;
                    result = root.key;
                }
                root = root.right;
            }else if(target<root.key){
                double diff = Math.abs(root.key-target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.key;
                }
                root = root.left;
            }else{
                return root.key;
            }
        }

        return result;
    }
}
