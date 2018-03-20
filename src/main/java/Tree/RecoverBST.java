package Tree;

/**
 * Created by hakanmehmed on 19/03/2018.
 */
public class RecoverBST {
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

    static Node swap1;
    static Node swap2;
    static Node prev;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.right.left = new Node(14);
        root.right.right = new Node(17);
        inorder(root);

        // convert to invalid bst
        root.left.key = 15;
        root.right.key = 5;
        System.out.println();
        inorder(root);
        System.out.println();
        System.out.println("Recovered: ");
        recoverBST(root);
        int temp = swap1.key;
        swap1.key = swap2.key;
        swap2.key = temp;
        inorder(root);
    }


    private static void recoverBST(Node root) {
        if(root == null) return;
        recoverBST(root.left);
        if(prev != null){
            if(prev.key > root.key){
                if(swap1 == null){
                    swap1 = prev;
                }
                swap2 = root;
            }
        }
        prev = root;
        recoverBST(root.right);

    }

    private static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);


    }

}
