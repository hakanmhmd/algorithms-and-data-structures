package Arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class ThirdMaxNumber {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1};
        System.out.println(thirdMax(arr));
    }

    //linear space - heap
    private static int thirdMax2(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums) {
            if(!set.contains(n)){
                heap.offer(n);
                set.add(n);
                if(heap.size() > 3){
                    Integer del = heap.poll();
                    set.remove(del);
                }
            }
        }

        if(heap.size() == 3){
            return heap.poll();
        } else {
            while(heap.size() != 1){
                heap.poll();
            }
            return heap.poll();
        }
    }

    // constant space
    private static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer i : nums) {
            if (i.equals(max1) || i.equals(max2) || i.equals(max3)) continue;

            if (max1 == null || i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;

            } else if (max2 == null || i > max2) {
                max3 = max2;
                max2 = i;
            } else if (max3 == null || i > max3) {
                max3 = i;
            }
        }

        return (max3 != null) ? max3 : max1;

        /**
         * long first=Long.MIN_VALUE;
         long second=Long.MIN_VALUE;
         long third=Long.MIN_VALUE;
         for(int i:nums){
         if(i>first){
         third=second;
         second=first;
         first=i;
         }else if(i==first)
         continue;
         else if(i>second){
         third=second;
         second=i;
         }else if(i==second)
         continue;
         else if(i>third){
         third=i;
         }
         }
         return third==Long.MIN_VALUE?(int)first:(int)third;
         */

    }
}
