package stack;

import linkedlist.SinglyLinkedList;

/**
 * Created by Temurbek Ismoilov on 20/01/23.
 */

public class LinkedListStack implements Stack {
    private SinglyLinkedList container;

    public LinkedListStack() {
        this.container = new SinglyLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return container.head == null;
    }

    @Override
    public void push(int value) {
        container.insertNode(value, 0);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int result = container.head.value;
        container.deleteNode(0);
        return result;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
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
        return null;
    }
}
