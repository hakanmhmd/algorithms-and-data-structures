package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash table with pointers to Doubly linked lists
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return null.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache<T> {
    private class Node<T> {
        //private Integer key;
        private T value;
        private Node<T> next;
        private Node<T> prev;
        public Node(T value){ //constructor
            //this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<T, Node<T>> map = new HashMap<>();
    Node<T> head = null;
    Node<T> tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public T get(T key){
        if(map.containsKey(key)){
            Node<T> n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return null;
    }

    public void set(T key, T value){
        if(map.containsKey(key)){
            Node<T> old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node<T> newNode = new Node<T>(value);
            if(map.size() >= capacity){
                // remove least recently used
                map.remove(tail.value);
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

    private void visit(T v){
        T t = get(v);
        if(t == null){
            set(v, v);
        }
    }

    private T getLastVisit(){
        return head.value;
    }

    public static void main(String[] args) {
        LRUCache<String> history = new LRUCache<>(3);

        history.visit("bbc.co.uk");
        history.print();
        history.visit("cnn.com");
        history.print();
        history.visit("bloomberg.com");
        history.print();
        history.visit("google.com");
        history.print();
        history.visit("cnn.com");
        history.print();
        history.visit("google.com");
        history.print();
        System.out.println(history.getLastVisit());

//        history.set("bbc.co.uk", "bbc.co.uk");
//        history.set("cnn.com", "cnn.com");
//        history.set("bloomberg.com", "bloomberg.com");
//        history.set("google.com", "google.com");
//        history.print();
//
//        System.out.println(history.get("bbc.co.uk"));
//        System.out.println(history.get("cnn.com"));
//        history.print();
//        history.set("lala.com", "lala.com");
//
//        history.print();

    }

    private void printMap() {
        for(Map.Entry<T, Node<T>> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue().value);
        }
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
