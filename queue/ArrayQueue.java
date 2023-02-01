package queue;

import java.util.Arrays;

/**
 * Created by Temurbek Ismoilov on 20/01/23.
 */

public class ArrayQueue implements Queue {

    private int[] array;
    private int beginning;
    private int end;

    public ArrayQueue(int size){
        this.array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        this.beginning = -1;
        this.end = -1;
    }

    @Override
    public boolean isEmpty() {
        return beginning == -1 && end == -1;
    }

    @Override
    public boolean isFull() {
        return (beginning == end+1) || (beginning == 0 && end == array.length-1);
    }

    @Override
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("The stack is full");
            return;
        }

        if (isEmpty()) {
            end = beginning = 0;
        } else if (end == array.length - 1) {
            end = 0;
        } else {
            end++;
        }

        array[end] = value;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return -1;
        } else {
            int result = array[beginning];
            array[beginning] = -1;

            if (beginning == end) {
                beginning = end = -1;
            } else if (beginning == array.length-1) {
                beginning = 0;
            } else {
                beginning++;
            }

            return result;
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return array[beginning];
    }

    @Override
    public void delete() {
        array = null;
        beginning = end = -1;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + Arrays.toString(array) +
                ", beginning=" + beginning +
                ", end=" + end +
                '}';
    }
}
