package queue;

import linkedlist.LinkedList;
import linkedlist.SinglyLinkedList;

/**
 * Created by Temurbek Ismoilov on 20/01/23.
 */

public class LinkedListQueue implements Queue {
    private SinglyLinkedList container;

    public LinkedListQueue() {
        this.container = new SinglyLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return container.head == null;
    }

    @Override
    public void enqueue(int value) {
        container.insertNode(value);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }

        int result = container.head.value;
        container.deleteNode(0);

        return result;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }

        return container.head.value;
    }

    @Override
    public void delete() {
        container.head = container.tail = null;
        container.size = 0;
    }


    @Override
    public String toString() {
        this.container.traversal();
        return "";
    }
}
