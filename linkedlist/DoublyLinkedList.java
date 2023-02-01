package linkedlist;


/**
 * Created by Temurbek Ismoilov on 17/01/23.
 */

public class DoublyLinkedList implements LinkedList{
    public Node head;
    public Node tail;
    public int size;

    @Override
    public void create(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        head = tail = newNode;
        newNode.next = null;
        newNode.previous = null;
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
            head.previous = newNode;
            head = newNode;
            size++;
        } else if (location >= size) {
            Node newNode = new Node(nodeValue);
            newNode.next = null;
            newNode.previous = tail;
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
            newNode.previous = pointer;
            pointer.next.previous = newNode;
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
            System.out.println("Linked list doesn't exist");
        } else if (location == 0) {
            head = head.next;
            head.previous = null;
            size--;
            if (size==0) {
                tail = head = null;
            }
        } else if (location >= size-1) {
            Node temp = head;
            for (int i = 1; i < size - 1; i++) {
                temp = temp.next;
            }
            if (temp == head) {
                head = tail = null;
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
            temp.next.previous = temp;
            size--;
        }
    }

    @Override
    public void deleteLL() {
        Node pointer = head;
        for (int i = 0; i < size; i++) {
            pointer.previous = null;
            pointer = pointer.next;
        }
        head = tail = null;
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

    public void traversalBack() {
        if (size==0) {
            System.out.println("Linked list is empty");
        }
        Node tempNode = tail;
        for (int i = size-1; i > -1; i--) {
            System.out.print(tempNode.value);
            if (i != 0) {
                System.out.print(" -> ");
            }
            tempNode = tempNode.previous;
        }
        System.out.println("\n");
    }
}
