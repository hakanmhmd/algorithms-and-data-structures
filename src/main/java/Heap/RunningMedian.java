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
        int[] arr = {12,4,5,3,8,7};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> x - y);
        double currentMedian = 0.0;

        for(int i=0; i<arr.length; i++){
            int val = arr[i];
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
    PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> y - x);
    PriorityQueue<Integer> min = new PriorityQueue<>((x, y) -> x - y);
    int len = 0;
    // Adds a number into the data structure.
    public void addNum(int num) {
        //if the number of elements is even then we need to add the new element to the max heap
        if(len%2==0){
            max.offer(num);
        }else{
            //if the number of elements is odd then we need to add the new element to the maxheap
            //then transfer the root of the max heap to the min heap
            max.offer(num);
            min.offer(max.poll());
        }

        //increment the size
        len++;

        //if the root of max heap > root of min heap, then it conficts our order rule
        //so we shift the max heap's root to min heap and add the minimum element of our
        //min heap to max heap
        if(len > 1 && max.peek() > min.peek()){
            min.offer(max.poll());
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (len%2==0)?((double)((max.peek()+min.peek())/2.0)):((double)max.peek());
    }
}
