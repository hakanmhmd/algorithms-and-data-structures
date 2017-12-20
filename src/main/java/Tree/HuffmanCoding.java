package Tree;

/**
 * https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 * variable length coding
 * 0 - left
 * 1 - right
 */
public class HuffmanCoding {
    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

        public Node(char data, int freq){
            this.data = data;
            this.frequency = freq;
        }
    }

    static void decode(String S, Node root)
    {
        Node current = root;
        StringBuilder decoded = new StringBuilder();
        for(char a: S.toCharArray()) {
            if(a == '0'){
                current = current.left;
            } else if (a == '1') {
                current = current.right;
            }

            // leaf?
            if(current.data != '-'){
                decoded.append(current.data);
                current = root;
            }
        }

        System.out.println(decoded.toString());
    }

    public static void main(String[] args) {
        Node root = new Node('-', 5);
        root.left = new Node('-', 2);
        root.right = new Node('A', 3);
        root.left.left = new Node('B', 1);
        root.left.right = new Node('C', 1);

        decode("1001011", root);
    }
}
