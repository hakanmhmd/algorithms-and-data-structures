package Arrays;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a set of interval group overlapping
 *
 * Cases: [(1, 2), (2, 3)]
 *        [(1, 5), (2, 3)]
 *
 *  What if we did have an upper bound on the input values? Could we improve our runtime? Would it cost us memory?
 *  Could we do this "in-place" on the input list and save some space? What are the pros and cons of doing this in-place?
 */
public class GroupIntervals {
    static class Interval {
        public int start;
        public int end;

        public Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        Interval arr[] =  {
                new Interval(1,3),
                new Interval(0,4),
                new Interval(0,3),
                new Interval(5,7),
                new Interval(7,9)
        };
        mergeIntervals(arr);

    }

    private static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, new IntervalComparator());


        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].start <= arr[index-1].end){
                arr[index-1].end = Math.max(arr[index-1].end, arr[i].end);
                arr[index-1].start = Math.min(arr[index-1].start, arr[i].start);
            } else {
                arr[index] = arr[i];
                index++;
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.println("[ " + arr[i].start + " " + arr[i].end + " ]");
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0 ) return res;

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval obj1, Interval obj2) {
                return obj1.start - obj2.start;
            }
        });

        Interval pre = intervals.get(0);
        res.add(pre);

        int index = 0;
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start <= res.get(index).end){
                Interval merged = new Interval(Math.min(res.get(index).start, curr.start),
                        Math.max(res.get(index).end, curr.end));
                res.remove(index);
                res.add(merged);
            } else {
                res.add(curr);
                index++;
            }
        }

        return res;
    }

    private static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
}
