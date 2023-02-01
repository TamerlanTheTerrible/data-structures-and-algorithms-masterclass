package linkedlist;

/**
 * Created by Temurbek Ismoilov on 19/01/23.
 */

public interface LinkedList {
    void create(int nodeValue);

    void insertNode(int nodeValue);

    void insertNode(int nodeValue, int location);

    int searchNode(int nodeValue);

    void deleteNode(int location);

    void deleteLL();

    void traversal();

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
