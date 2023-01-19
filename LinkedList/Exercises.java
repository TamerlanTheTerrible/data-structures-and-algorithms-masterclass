package LinkedList;

import java.util.HashSet;

/**
 * Created by Temurbek Ismoilov on 17/01/23.
 */

public class Exercises {

    public void deleteDups(SinglyLinkedList singlyLinkedList) {
        HashSet<Integer> set = new HashSet<>();
        Node currentNode = singlyLinkedList.head;
        set.add(currentNode.value);
        while (currentNode.next != null) {
            if (set.contains(currentNode.next.value)) {
                if (currentNode.next == singlyLinkedList.tail) {
                    singlyLinkedList.tail = currentNode;
                }
                currentNode.next = currentNode.next.next;
                singlyLinkedList.size--;
            } else {
                set.add(currentNode.next.value);
            }
            currentNode = currentNode.next;
        }
    }

    //    Implement and algorithm to find the nth to last element of a singly linked list.
    public Node nthToLast(SinglyLinkedList singlyLinkedList, int location) {
        Node temp = singlyLinkedList.head;
        for (int i = 0; i < singlyLinkedList.size-location; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
    /* Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [x=5]
    Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8 */
    public SinglyLinkedList partition(SinglyLinkedList singlyLinkedList, int value) {
        Node pointer = singlyLinkedList.head;
        while (pointer.next != null) {
            if (pointer.next.value < value) {
                Node temp = pointer.next;
                pointer.next = temp.next;
                temp.next = singlyLinkedList.head;
                singlyLinkedList.head = temp;
            }
            if (pointer.next == singlyLinkedList.tail && singlyLinkedList.tail.value < value) {
                Node temp = singlyLinkedList.tail;
                pointer.next = temp.next;
                temp.next = singlyLinkedList.head;
                singlyLinkedList.head = temp;
                singlyLinkedList.tail = pointer;
            } else {
                pointer = pointer.next;
            }
        }
        return singlyLinkedList;
    }

    /*
    You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
    list1 = 7 -> 1 -> 6
    list2 =  5 -> 9 -> 2
    result = 2 -> 1 -> 9
     */

    public SinglyLinkedList sumLists(SinglyLinkedList first, SinglyLinkedList second) {
        SinglyLinkedList result = new SinglyLinkedList();
        Node firstNode = first.head;
        Node secondNode = second.head;
        int dozen = 0;

        for (int i = 0; i < first.size; i++) {
            int nodeVal = firstNode.value + secondNode.value + dozen;
            if (nodeVal > 9) {
                nodeVal = nodeVal % 10;
                dozen = 1;
            } else {
                dozen = 0;
            }

            result.insertNode(nodeVal);

            if (firstNode == first.tail && dozen == 1) {
                result.insertNode(dozen);
            }

            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return result;
    }

    // Add same node
    public void addSameNode(SinglyLinkedList llA, SinglyLinkedList llB, int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        llA.tail.next = newNode;
        llA.tail = newNode;
        llA.size++;
        llB.tail.next = newNode;
        llB.tail = newNode;
        llB.size++;
    }

    // Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node
    public Node findIntersection(SinglyLinkedList ll1, SinglyLinkedList ll2) {
        Node ll1Node = ll1.head;
        Node ll2Node = ll2.head;
        for (int i = 0; i < ll1.size; i++) {
            for (int j = 0; j < ll2.size; j++) {
                if (ll1Node == ll2Node) {
                    return ll1Node;
                }
                if (ll2Node != ll2.tail) {
                    ll2Node = ll2Node.next;
                }
            }
            ll2Node = ll2.head;
            if (ll1Node != ll1.tail) {
                ll1Node = ll1Node.next;
            }
        }
        return new Node();
    }
}
