import java.util.HashMap;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message should be
 * printed if and only if it is not printed in the last 10 seconds.

 Given a message and a timestamp (in seconds granularity), return true if the message should be
 printed in the given timestamp, otherwise returns false.

 It is possible that several messages arrive roughly at the same time.
 */
public class LoggerRateLimiter {
    public static void main(String[] args) {
        LoggerLimiter logger = new LoggerLimiter();

        // logging string "foo" at timestamp 1
        logger.shouldPrintMessage(1, "foo");

        // logging string "bar" at timestamp 2
        logger.shouldPrintMessage(2,"bar");

        // logging string "foo" at timestamp 3
        logger.shouldPrintMessage(3,"foo");

        // logging string "bar" at timestamp 8
        logger.shouldPrintMessage(8,"bar");

        // logging string "foo" at timestamp 10
        logger.shouldPrintMessage(10,"foo");

        // logging string "foo" at timestamp 11
        logger.shouldPrintMessage(11,"foo");
    }

    private static class LoggerLimiter {
        HashMap<String, Integer> map = new HashMap<>();

        public boolean shouldPrintMessage(int timestamp, String msg) {
            if(!map.containsKey(msg) || timestamp - map.get(msg) >=10){
                map.put(msg, timestamp);
                System.out.println("YES");
                return true;
            } else {
                System.out.println("NO");
                return false;
            }
        }
    }
}
