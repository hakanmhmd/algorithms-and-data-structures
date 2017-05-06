package Queue;

/**
 * Interface for array based queue
 */

public interface Queue<Item> {
    void enqueue(Item i);
    Item dequeue();
    Item pop();
}
