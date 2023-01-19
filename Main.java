
import LinkedList.*;

/**
 * Created by Temurbek Ismoilov on 17/01/23.
 */

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList llA = new CircularDoublyLinkedList();
        llA.create(10);
        llA.insertNode(20, 1);
        llA.insertNode(30, 2);
        llA.traversal();
        llA.traversalBack();

        llA.deleteNode(2);
        llA.traversal();
        llA.traversalBack();
    }
}
