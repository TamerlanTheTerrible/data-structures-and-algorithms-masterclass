package stack;

/**
 * Created by Temurbek Ismoilov on 20/01/23.
 */

public interface Stack {
    boolean isEmpty();
    default boolean isFull() { return false;}
    void push(int value);
    int pop();
    int peek();
    void delete();
}
