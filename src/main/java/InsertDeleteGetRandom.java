import java.util.*;

/**
 * Design a data structure that supports following operations in Θ(1) time.
 * <p>
 * insert(x): Inserts an item x to the data structure if not already present.
 * <p>
 * remove(x): Removes an item x from the data structure if present.
 * <p>
 * search(x): Searches an item x in the data structure.
 * <p>
 * getRandom(): Returns a random element from current set of elements
 */
public class InsertDeleteGetRandom {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.get(val) != null) {
            System.out.println("Set contains val " + val);
            return false;
        }

        int index = list.size();
        list.add(val);
        map.put(val, index);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.get(val) == null) {
            System.out.println("No element with value " + val);
            return false;
        }


        int index = map.get(val);
        map.remove(val);
        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);


        if (index == lastIndex) {
            list.remove(lastIndex);
        } else {
            Collections.swap(list, index, lastIndex);
            list.remove(lastIndex);
            //update map
            map.put(lastElement, index);
        }

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

    public int search(int val) {
        if (map.get(val) != null) return map.get(val);
        return -1;
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom ds = new InsertDeleteGetRandom();
//        ds.insert(10);
//        ds.insert(15);
//        ds.insert(20);
//
//        System.out.println("Index: " + ds.search(20));
//        ds.remove(10);
//        System.out.println("Index: " + ds.search(20));
//
//        System.out.println("Index: " + ds.search(22));
//        ds.remove(22);
//        ds.insert(15);
//
//        System.out.println("Random: " + ds.getRandom());
//        System.out.println("Random: " + ds.getRandom());
//        System.out.println("Random: " + ds.getRandom());

        ds.insert(0);
        ds.remove(0);
        ds.insert(-1);
        ds.remove(0);
        ds.getRandom();
        ds.getRandom();
        ds.getRandom();
        ds.getRandom();
        ds.getRandom();
    }
}
