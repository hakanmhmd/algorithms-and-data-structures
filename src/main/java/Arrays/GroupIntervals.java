package Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hakanmehmed on 12/11/2017.
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
                new Interval(2,4),
                new Interval(0,3),
                new Interval(5,7)
        };
        mergeIntervals(arr);

    }

    private static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, new IntervalComparator());

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(index != 0 && arr[i].start < arr[index-1].end){
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

    private static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
}
