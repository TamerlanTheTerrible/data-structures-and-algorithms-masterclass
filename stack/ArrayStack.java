package stack;

import java.util.Arrays;

/**
 * Created by Temurbek Ismoilov on 20/01/23.
 */

public class ArrayStack implements Stack {
    private int[] container;
    private int top;

    public ArrayStack(int size) {
        this.container = new int[size];
        for (int i = 0; i < container.length-1; i++) {
            container[i] = -1;
        }

        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;

    }

    @Override
    public boolean isFull() {
        return top == container.length-1;
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            System.out.println("the stack is full");
        } else {
            container[++top] = value;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("the stack is empty");
            return -1;
        }
        int result = container[top];
        container[top] = -1;
        top--;

        return result;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("the stack is empty");
            return -1;
        }
        return container[top];
    }

    @Override
    public void delete() {
        container = null;
        top = -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(container);
    }
}
