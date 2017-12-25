package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 * max heap - keeps all elements less than current median
 * min heap - keeps all elements greater than current median
 */
public class RunningMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> x - y);
        double currentMedian = 0.0;

        for(int i=0; i<n; i++){
            int val = in.nextInt();
            if(val >= currentMedian){
                minHeap.offer(val);
            } else {
                maxHeap.offer(val);
            }
            if(minHeap.size() == maxHeap.size()){
                currentMedian = (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else if(minHeap.size() > maxHeap.size()){
                if(minHeap.size() == maxHeap.size() + 1){
                    currentMedian = minHeap.peek();
                } else {
                    while(minHeap.size() != maxHeap.size()){
                        maxHeap.offer(minHeap.poll());
                    }
                    currentMedian = (minHeap.peek() + maxHeap.peek()) / 2.0;
                }
            } else {
                if(minHeap.size() + 1 == maxHeap.size()){
                    currentMedian = maxHeap.peek();
                } else {
                    while(minHeap.size() != maxHeap.size()){
                        minHeap.offer(maxHeap.poll());
                    }
                    currentMedian = (minHeap.peek() + maxHeap.peek()) / 2.0;
                }
            }

            System.out.println(String.format("%.1f", currentMedian));
        }


    }
}
