import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hakanmehmed on 08/08/2018.
 */
public class WaveletTree {
    static class Node {
        Node left, right;
        List<Integer> nums;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        public List<Integer> leftCount;
        boolean isLeaf = false;

        public Node(List<Integer> arr) {
            this.nums = arr;
            for(int i=0; i<arr.size(); i++){
                this.min = Math.min(min, arr.get(i));
                this.max = Math.max(max, arr.get(i));
            }
        }
    }

    public static void main(String[] args) {
        //8, 7, 14, 6, 12, 6, 8, 9, 21, 12, 14, 6, -1, 2, 2, 18, 7, 6
        List<Integer> list = Arrays.asList(2,1,7,6,4,8,9,4,3,7,5,9,2,7);
        Node root = buildWaveletTree(list);

        System.out.println(rankInRange(9, 4, 12, root)); // number of 9s in range 4-12
        System.out.println(quantileInRange(3, 4, 10, root)); // 3th smallest element in range 4-10
    }

    private static int quantileInRange(int k, int i, int j, Node root) {
        if(k==0 || root.isLeaf) return root.nums.get(0);
        int elementsToLeft = root.leftCount.get(j+1) - root.leftCount.get(i);
        if(elementsToLeft >= k){
            return quantileInRange(k, root.leftCount.get(i+1)-1, root.leftCount.get(j+1)-1, root.left);
        } else {
            return quantileInRange(k-elementsToLeft, i-root.leftCount.get(i+1), j-root.leftCount.get(j+1), root.right);
        }
    }

    private static int rankInRange(int x, int i, int j, Node root) {
        return rankHelper(x, j, root) - rankHelper(x, i-1, root);
    }

    private static int rankHelper(int x, int i, Node root) {
        if(root.isLeaf){
            return i+1;
        }
        double pivot = (root.max + root.min) / 2.0;

        if(x > pivot){
            return rankHelper(x, i-root.leftCount.get(i+1), root.right);
        } else {
            return rankHelper(x, root.leftCount.get(i+1)-1, root.left);
        }
    }

    private static Node buildWaveletTree(List<Integer> arr) {
        Node root = new Node(arr);
        if(sameValues(arr)) {
            root.isLeaf = true;
            return root;
        }
        double pivot = (root.min + root.max) / 2.0;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> leftCount = new ArrayList<>();
        int lc=0;
        for(int i=0; i<root.nums.size(); i++){
            leftCount.add(lc);
            if(arr.get(i) <= pivot){
                left.add(arr.get(i));
                lc++;
            } else {
                right.add(arr.get(i));
            }
        }
        leftCount.add(lc);
        root.leftCount = leftCount;
        root.left = buildWaveletTree(left);
        root.right = buildWaveletTree(right);

        return root;


    }

    private static boolean sameValues(List<Integer> arr) {
        for(int i=1; i<arr.size(); i++){
            if(arr.get(i) != arr.get(0)) return false;
        }
        return true;
    }
}
