package linkedlist;

/**
 * Created by Temurbek Ismoilov on 19/01/23.
 */

public class CircularSinglyLinkedList implements LinkedList {
    public Node head;
    public Node tail;
    public int size;

    @Override
    public void create(int nodeValue) {
        Node node = new Node(nodeValue);
        node.next = node;
        head = tail = node;
        size=1;
    }

    @Override
    public void insertNode(int nodeValue) {
        insertNode(nodeValue, size);
    }

    @Override
    public void insertNode(int nodeValue, int location) {
        if (head == null) {
            create(nodeValue);
        } else if (location == 0) {
            Node newNode = new Node(nodeValue);
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
            size++;
        } else if (location >= size-1) {
            Node newNode = new Node(nodeValue);
            newNode.next = head;
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

    @Override
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

    @Override
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The linked list is empty");
        } else if (location == 0) {
            head = head.next;
            tail = head;
            size--;
            if (size==0) {
                head.next = null;
                head = tail = null;
            }
        } else if (location >= size) {
            Node pointer = head;
            for (int i = 1; i < size-1; i++) {
                pointer = pointer.next;
            }
            if (pointer == head) {
                pointer.next = null;
                head = tail = null;
            } else {
                pointer.next = head;
                tail = head;
            }
            size--;
        } else {
            Node pointer = head;
            for (int i = 1; i < location; i++) {
                pointer = pointer.next;
            }
            pointer.next = pointer.next.next;
            size--;
        }
    }

    @Override
    public void deleteLL() {
        tail.next = null;
        tail = head = null;
        size = 0;
    }

    @Override
    public void traversal() {
        if (size==0) {
            System.out.println("Linked list is empty");
        }
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            if (i != size-1) {
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println("\n");
    }
}
