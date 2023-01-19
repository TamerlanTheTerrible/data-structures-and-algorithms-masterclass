package LinkedList;

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
}
