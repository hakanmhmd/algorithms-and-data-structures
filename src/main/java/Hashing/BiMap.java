package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashMap like datastructure with one to one mapping between keys and values
 * Bijective Map
 * getKey(k) and getValue(v) in O(1)
 */
public class BiMap<T1, T2> {
    static class Entry<T1, T2>{
        public T1 key;
        public T2 value;

        public Entry(T1 key, T2 value){
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Object, Entry<T1, T2>> mappings = new HashMap<>();

    public void put(T1 key, T2 value){
        remove(key);
        remove(value);
        Entry<T1, T2> entry = new Entry<>(key, value);
        if(Objects.equals(key, value)){
            mappings.put(key, entry);
        } else {
            mappings.put(key, entry);
            mappings.put(value, entry);
        }

    }

    // Hashmap lookup using either the key or the value should return the key-value entry
    public Entry<T1, T2> get(Object keyValue){
        return mappings.get(keyValue);
    }

    public Entry<T1, T2> remove(Object keyValue) {
        Entry<T1, T2> entry = mappings.remove(keyValue);
        if(entry == null) return null;
        if(Objects.equals(keyValue, entry.key)){
            return mappings.remove(entry.value);
        } else {
            return mappings.remove(entry.key);
        }
    }

    public int size(){
        return mappings.size();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Entry<T1, T2>> entry : mappings.entrySet()) {
            sb.append(entry.getKey().toString() + " -> Entry(" + entry.getValue().key.toString()
                    + ", " + entry.getValue().value.toString() + ")");
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BiMap<String, String> bimap = new BiMap<>();
        bimap.put("x", "y");
        bimap.put("a", "a");
        System.out.println(bimap.toString());

        bimap.remove("x");
        System.out.println(bimap.toString());

        bimap.put("a", "b");
        System.out.println(bimap.toString());
    }
}
