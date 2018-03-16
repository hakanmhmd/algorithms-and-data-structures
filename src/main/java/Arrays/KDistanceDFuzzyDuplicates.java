package Arrays;

import java.util.TreeSet;

/**
 * Given an unsorted list of integers, return true if the list  contains any fuzzy duplicates within
 * k indices of each element. A fuzzy duplicate is another integer within d of the original integer.
 *
 * Example:
 *	[1, 5, 2, 9] k = 2  d = 1 (2 - 1 = a[0]-a[2] <= 2) -- true
 *	[1, 5, 9, 2] k = 2  d = 1 (2 - 1 = a[0]-a[3] > 2) -- false
 */
public class KDistanceDFuzzyDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,9,2,10,13, 2, 14};
        int k = 2;
        int d = 1;

        System.out.println(containsFuzzyDups(arr, k ,d));
    }

    private static boolean containsFuzzyDups(int[] nums, int k, int d) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        TreeSet<Integer> values = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            Integer floor = values.floor(nums[i] + d); // return the greatest element in this set less than or equal to the given element
            Integer ceiling = values.ceiling(nums[i] - d); // return the least element in this set greater than or equal to the given element
            //System.out.println(floor + " " + ceiling);

            if ((floor != null && floor >= nums[i])
                    || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }

            values.add(nums[i]);
            if(i >= k){
                values.remove(nums[i-k]);
            }

        }
        return false;
    }
}
