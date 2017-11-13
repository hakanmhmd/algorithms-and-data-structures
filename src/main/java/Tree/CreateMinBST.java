package Tree;


/**
 * Create minimal binary search tree from a sorted array
 */
public class CreateMinBST {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        /*

                  5
               2      8
             1   4  7   10
                3  6    9
          */


        TreeNode root = createMinimalBST(array);
        System.out.println("Root? " + root.key);
    }

    public static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        if(end < start) return null;

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);

        n.left = createMinimalBST(array, start, mid-1);
        n.right = createMinimalBST(array, mid+1, end);

        return n;
    }
}
