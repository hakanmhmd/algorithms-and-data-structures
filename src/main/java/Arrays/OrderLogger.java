package Arrays;

/**
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

 record(order_id): adds the order_id to the log
 get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 You should be as efficient with time and space as possible.
 */
public class OrderLogger {
    private int[] circularArray;
    private int currentIndex;
    OrderLogger(int n){
        circularArray = new int[n];
        currentIndex = 0;
    }

    public void record(int orderId){
        circularArray[currentIndex] = orderId;
        currentIndex++;

        if(currentIndex == circularArray.length){
            currentIndex = 0;
        }
    }

    public int getLast(int i){
        int index = currentIndex-i;
        if(index < 0)
            return circularArray[circularArray.length - Math.abs(currentIndex - i)];
        else
            return circularArray[index];
    }

    public static void main(String[] args) {
        OrderLogger logger = new OrderLogger(5);
        logger.record(14146);
        logger.record(1232);
        logger.record(3);
        logger.record(56);
        logger.record(234);
        logger.record(1234);

        System.out.println(logger.getLast(1));
        System.out.println(logger.getLast(2));
        System.out.println(logger.getLast(3));
        System.out.println(logger.getLast(4));
        System.out.println(logger.getLast(5));
    }
}
