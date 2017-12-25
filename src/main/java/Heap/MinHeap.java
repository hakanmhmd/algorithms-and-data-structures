package Heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementation of minimum heap
 * Operations:
 *   - insert
 *   - delete
 *   - getMin
 *
 */
public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> items;

    public MinHeap(){
        items = new ArrayList<T>();
    }

    public void insert(T data){
        items.add(data);
        heapifyUp();
    }

    public T getMin(){
        if(isEmpty()) throw new NoSuchElementException("Underflow Exception");
        return items.get(0);
    }

    public T deleteMin(){
        T k = getMin();
        delete(k);
        return k;
    }

    private void heapifyUp() {
        int i = items.size()-1;
        while(i > 0){
            int pIndex = getParentIndex(i);
            T item = items.get(i);
            T parent = items.get(pIndex);
            if(item.compareTo(parent) < 0){
                items.set(i, parent);
                items.set(pIndex, item);

                i = pIndex;
            } else {
                break;
            }
        }
    }

    public T delete(T data){
        if(isEmpty()) throw new NoSuchElementException("Underflow Exception");
        int i = getIndex(data);
        if(i == -1) throw new NoSuchElementException("Underflow Exception");
        if(i == items.size()-1){
            items.remove(i);
            return data;
        } else {
            T last = items.remove(items.size() - 1);
            items.set(i, last);
            heapifyDown(i);
            return data;
        }
    }

//    public T delete(int index){
//        return delete(items.get(index));
//    }

    private void heapifyDown(int index) {
        T item = items.get(index);
        while(getLeftChildIndex(index) < items.size()){
            int leftChild = getLeftChildIndex(index);
            int minChild = leftChild;
            int rightChild = getRightChildIndex(index);
            if(rightChild < items.size()) {
                if(items.get(rightChild).compareTo(items.get(leftChild)) < 0){
                    minChild = rightChild;
                }
            }
            if(items.get(index).compareTo(items.get(minChild)) > 0){
                items.set(index, items.get(minChild));
                items.set(minChild, item);
                index = minChild;
            } else {
                break;
            }
        }
    }



    private int getIndex(T data) {
        return items.indexOf(data);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private int getLeftChildIndex(int i){
        return 2*i + 1;
    }

    private int getRightChildIndex(int i){
        return 2*i + 2;
    }

    private int getParentIndex(int i){
        return (i-1)/2;
    }

    public static void main(String[] args) {
        MinHeap<Long> minHeap = new MinHeap<>();
        minHeap.insert(1000000000L);
        minHeap.insert(100000000L);
        minHeap.insert(10000000L);
        minHeap.insert(1000000L);
        System.out.println(minHeap.getMin());
        minHeap.insert(100000L);
        System.out.println(minHeap.getMin());
        minHeap.insert(10000L);
        System.out.println(minHeap.getMin());
        minHeap.insert(1000L);
        System.out.println(minHeap.getMin());
        minHeap.delete(1000L);
        System.out.println(minHeap.getMin());
        minHeap.delete(1000000000L);
        System.out.println(minHeap.getMin());
        minHeap.insert(-100000L);
        System.out.println(minHeap.getMin());
        minHeap.delete(100000000L);
        System.out.println(minHeap.getMin());
        minHeap.delete(10000000L);
        System.out.println(minHeap.getMin());
    }
}
