package Heap;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/minimum-average-waiting-time/problem
 * Keeping two queues - with all customers and with waiting customers
 */
public class MinAverageWaitingTime {
    static class Customer {
        int arrival;
        int order;

        public Customer(int a, int o){
            this.arrival = a;
            this.order = o;
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Customer> all = new PriorityQueue<>((o1, o2) -> o1.arrival - o2.arrival);
        for (int i = 0; i < n; i++) {
           all.offer(new Customer(in.nextInt(), in.nextInt()));
        }

        PriorityQueue<Customer> waiting = new PriorityQueue<>((o1, o2) -> o1.order - o2.order);

        long time = 0;
        long waitTime = 0;
        while(true){
            if(waiting.isEmpty()){
                if(all.isEmpty()){
                    break;
                }
                Customer poll = all.poll();
                time = poll.arrival;
                waiting.offer(poll);
            } else {
                Customer next = waiting.remove();
                time = time + next.order;
                waitTime += (time - next.arrival);
                while(!all.isEmpty() && all.peek().arrival <= time){
                    waiting.offer(all.poll());
                }
            }

        }
        System.out.println(waitTime / n);

    }

}
