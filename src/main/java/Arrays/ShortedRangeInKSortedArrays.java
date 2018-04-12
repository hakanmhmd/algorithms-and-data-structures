package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes
 * at least one number from each of the k lists.
 */
public class ShortedRangeInKSortedArrays {
    static class Element implements Comparable{
        int listIndex;
        int value;

        Element(int a, int b)
        {
            this.listIndex = a;
            this.value = b;
        }

        @Override
        public int compareTo(Object o) {
            return this.value - ((Element)o).value;
        }
    }

    public static void main(String[] args) {
        int[][] lists = {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
        System.out.println(Arrays.toString(smallestRange(lists)));
    }

    public static int[] smallestRange(int[][] nums) {
        PriorityQueue<Element> q = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        int[] pointersReached = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            pointersReached[i] = 0;
            int[] arr = nums[i];
            if(arr[0] > max) max = arr[0];
            q.add(new Element(i, arr[0]));
        }

        int minRange = Integer.MAX_VALUE;
        int rangeStart = 0;
        int rangeEnd = 0;
        while(true){
            Element e = q.poll();
            if(max - e.value < minRange){
                rangeStart = e.value;
                rangeEnd = max;
                minRange = max - e.value;
            }

            if(pointersReached[e.listIndex] + 1 < nums[e.listIndex].length){
                pointersReached[e.listIndex]++;
                Element newElement = new Element(e.listIndex, nums[e.listIndex][pointersReached[e.listIndex]]);

                if(newElement.value > max) max = newElement.value;

                q.add(newElement);
            } else {
                break;
            }

        }
        System.out.println(rangeStart);
        System.out.println(rangeEnd);

        return null;
    }
}
