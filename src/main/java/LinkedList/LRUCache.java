package LinkedList;

import java.util.HashMap;

/**
 * Hash table with pointers to Doubly linked lists
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return null.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache<T> {

    

    private class Node<T> {
        private Integer key;
        private T value;
        private Node<T> next;
        private Node<T> prev;
        public Node(Integer key, T value){ //constructor
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node<T>> map = new HashMap<>();
    Node<T> head = null;
    Node<T> tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public T get(Integer key){
        if(map.containsKey(key)){
            Node<T> n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return null;
    }

    public void set(Integer key, T value){
        if(map.containsKey(key)){
            Node<T> old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node<T> newNode = new Node<T>(key, value);
            if(map.size() >= capacity){
                // remove least recently used
                map.remove(tail.key);
                remove(tail);
            }

            setHead(newNode);
            map.put(key, newNode);
        }
    }

    private void setHead(Node<T> n) {
        n.next = head;
        n.prev = null;

        if(head != null){
            head.prev = n;
        }

        head = n;

        if(tail == null){
            tail = head;
        }
    }

    private void remove(Node<T> n) {
        if(n == null) return;
        
        /* Change next only if node to be deleted is NOT the last node */
        if(n.next != null){
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }

        /* Change prev only if node to be deleted is NOT the first node */
        if(n.prev != null){
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
    }

    public static void main(String[] args) {
        LRUCache<String> cache = new LRUCache<String>(10);

        cache.set(1, "bbc.co.uk");
        cache.set(2, "cnn.com");
        cache.set(3, "bloomberg.com");
        cache.set(4, "google.com");
        cache.print();

        cache.get(1);
        cache.get(2);

        cache.print();

    }

    private void print() {
        Node<T> current = head;
        while(current.next != null){
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println(current.value);
    }
}
