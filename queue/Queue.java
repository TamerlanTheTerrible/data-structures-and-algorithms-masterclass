package queue;

/**
 * Created by Temurbek Ismoilov on 20/01/23.
 */

public interface Queue {
    boolean isEmpty();

    default boolean isFull() { return false;}

    void enqueue(int value);

    int dequeue();

    int peek();

    void delete();
}
