import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * <p>
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are
 * being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may
 * assume that the earliest timestamp starts at 1.
 * <p>
 * It is possible that several hits arrive roughly at the same time.
 * <p>
 * What if the number of hits per second could be very large? Does your design scale?
 */
public class HitCounter {
    private static final int MAX = 5 * 60;

    static Queue<Integer> q = new LinkedList<>();
    static HashMap<Integer, Integer> timeCounter = new HashMap<>();
    int counter = 0;
    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }

    private int getHits(int time) {
        evict(time);
        return counter;
    }

    private void hit(int time) {
        evict(time);

        if(!timeCounter.containsKey(time)){
            q.offer(time);
        }

        timeCounter.put(time, timeCounter.getOrDefault(time, 0) + 1);

        counter++;
    }

    private void evict(int time) {
        while(!q.isEmpty() && time - q.peek() >= MAX){
            Integer oldest = q.poll();
            int c = timeCounter.get(oldest);
            counter -= c;
            timeCounter.remove(oldest);
        }
    }

}
