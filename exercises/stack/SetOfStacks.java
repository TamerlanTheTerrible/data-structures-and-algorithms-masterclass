package exercises.stack;

import java.util.ArrayList;

/**
 * Created by Temurbek Ismoilov on 21/01/23.
 */

public class SetOfStacks {
    private ArrayList<SinglyLinkedList> stacks;
    private final int stackSize;

    public SetOfStacks(int stackSize) {
        this.stackSize = stackSize;
        this.stacks = new ArrayList<>();
        this.stacks.add(new SinglyLinkedList());
    }

    private boolean isEmpty(int stackNum) {
        return stacks.get(stackNum).size == 0;
    }

    private boolean isFull(int stackNum) {
        return stacks.get(stackNum).size == stackSize;
    }

    public void push(int value) {
        final int stackNum = stacks.size() - 1;
        if (isFull(stackNum)) {
            SinglyLinkedList newStack = new SinglyLinkedList();
            newStack.insertNode(value);
            stacks.add(newStack);
            System.out.println(value + " pushed to NEW stack #" + (stacks.size() - 1));
        } else {
            stacks.get(stackNum).insertNode(value);
            System.out.println(value + " pushed to stack #" + (stacks.size() - 1));
        }
    }

    public int pop() {
        int theIndex = -1;
        for (int i = stacks.size() - 1; i > -1; i--) {
            if (!isEmpty(i)) {
                theIndex = i;
                break;
            }

            if (i == 0) {
                System.out.println("all stack are empty");
                return -1;
            }

            SinglyLinkedList emptyStack = stacks.remove(i);
            emptyStack.deleteLL();
        }

        SinglyLinkedList stack = stacks.get(theIndex);
        final int result = stack.tail.value;
        stack.deleteNode(stack.size);

        System.out.println(result + " popped from stack #" + theIndex);
        return result;
    }

    public int popAt(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("stack is empty");
            return -1;
        }

        SinglyLinkedList stack = stacks.get(stackNum);
        final int result = stack.tail.value;
        stack.deleteNode(stack.size);

        int stackNum2 = stackNum;
        while (stackNum2 < stacks.size() - 1) {
            SinglyLinkedList nextStack = stacks.get(++stackNum2);
            stack.insertNode(nextStack.head.value);
            nextStack.deleteNode(0);
            if (nextStack.head == null) {
                stacks.remove(stackNum2);
            }
            stack = nextStack;
        }

        System.out.println(result + " popped At #" + stackNum);
        return result;
    }

    class SinglyLinkedList {
        public Node head;
        public Node tail;
        public int size;

        public void create(int nodeValue) {
            Node newNode = new Node();
            newNode.value = nodeValue;
            head = tail = newNode;
            newNode.next = null;
            size=1;
        }

        public void insertNode(int nodeValue) {
            insertNode(nodeValue, size);
        }

        public void insertNode(int nodeValue, int location) {
            if (head == null) {
                create(nodeValue);
            } else if (location == 0) {
                Node newNode = new Node(nodeValue);
                newNode.next = head;
                head = newNode;
                size++;
            } else if (location >= size) {
                Node newNode = new Node(nodeValue);
                newNode.next = null;
                tail.next = newNode;
                tail = newNode;
                size++;
            } else {
                Node newNode = new Node(nodeValue);
                Node pointer = head;
                for (int i = 1; i < location; i++) {
                    pointer = pointer.next;
                }
                newNode.next = pointer.next;
                pointer.next = newNode;
                size++;
            }
        }

        public int searchNode(int nodeValue) {
            Node temp = head;
            for (int i = 0; i < size; i++) {
                if (temp.value == nodeValue) {
                    return i;
                }
                temp = temp.next;
            }
            return -1;
        }

        public void deleteNode(int location) {
            if (head == null) {
                System.out.println("Linked list doesn't exist");
            } else if (location == 0) {
                head = head.next;
                size--;
                if (size==0) {
                    tail = null;
                }
            } else if (location >= size-1) {
                Node temp = head;
                for (int i = 1; i < size - 1; i++) {
                    temp = temp.next;
                }
                if (temp == head && temp == tail) {
                    head.next = null;
                } else {
                    temp.next = null;
                    tail = temp;
                }
                size--;
            } else {
                Node temp = head;
                for (int i = 1; i < location; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        public void deleteLL() {
            head = tail = null;
            size = 0;
        }

        class Node {
            public int value;
            public Node previous;
            public Node next;

            public Node() {}

            public Node(int value) {
                this.value = value;
            }
        }
    }

}