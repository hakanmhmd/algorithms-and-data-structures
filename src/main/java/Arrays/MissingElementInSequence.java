package Arrays;

/**
 * Find missing element in a sequence in log time
 */
public class MissingElementInSequence {
    public static void main(String[] args) {
        int[] sequence = {1,2,4,5,6,7,8};
        System.out.println("The missing number from the above sequence is: " + findMissingElement(sequence, 0 ,sequence.length-1));
    }

    private static boolean correctlyPlaced(int index, int number) {
        // remember we are using 0 based indexing scheme
        if (number == (index + 1))
        {
            return true;
        }

        return false;
    }

    private static int findMissingElement(int[] sequence, int left, int right) {
        if (correctlyPlaced(right, sequence[right])) {
            System.out.println("No missing number. All elements are correctly placed");
            return 0;
        }
        if(left == right) return sequence[left] - 1;

        int mid = (left + right) / 2;

        if(!correctlyPlaced(mid, sequence[mid])){
            right = mid;
        } else {
            left = mid + 1;
        }
        return findMissingElement(sequence, left, right);

    }


}
