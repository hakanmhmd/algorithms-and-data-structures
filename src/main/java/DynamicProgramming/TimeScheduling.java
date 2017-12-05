package DynamicProgramming;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given start and end interval times of events ,
 * find the minimum number of collisions.
 */
public class TimeScheduling {
    public static int minMeetingRooms(Interval[] intervals) {
        if(intervals==null||intervals.length==0)
            return 0;

        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int collisions=1;
        queue.offer(intervals[0].end);
        System.out.println(collisions + " -> " + queue.toString());
        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start < queue.peek()){
                collisions++;

            }else{
                queue.poll();
            }

            queue.offer(intervals[i].end);
            System.out.println(collisions + " -> " + queue.toString());
        }

        return collisions;
    }

    public static void main(String[] args) {
        int[] startTimes = {1, 2, 5, 4, 1, 10, 11};
        int[] endTimes = {4, 5, 7, 6, 10, 20, 12};

        Interval[] intervals = new Interval[startTimes.length];
        for (int i = 0; i < startTimes.length; i++) {
            intervals[i] = new Interval(startTimes[i], endTimes[i]);
        }

        System.out.println(minMeetingRooms(intervals));
    }

    public static class Interval {
        public int start;
        public int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public String toString() {
            return "[ " + this.start + ", " + this.end + " ]";
        }
    }
}
