package Arrays;

/**
 *Suppose you have a long flowerbed in which some of the plots are planted and
 *  some are not. However, flowers cannot be planted in adjacent plots
 *  - they would compete for water and both would die.
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowers = {1,0,1,0,0,1,0,0,0,0,1,0,0};
        int n = 2;

        System.out.println(canPlaceFlowers(flowers,n));
    }

    private static boolean canPlaceFlowers(int[] nums, int n) {
        int i = 0;
        while(i<nums.length){
            if(nums[i] == 0){
                if((i == 0 || nums[i-1] == 0) && (i == nums.length-1 || nums[i+1] == 0)){
                    nums[i++] = 1;
                    n--;
                }
                // stop if n == 0?
            }
            i++;
        }

        return n<=0;
    }
}
