package exercises;

/**
 * Created by Temurbek Ismoilov on 11/02/23.
 */

public class SinglyLinkedList {
    public Node head = null;
    public Node tail = null;
    public int size = 0;

//    public boolean isEmpty() {
//        return head == null;
//    }

    public void push(int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        if (head==null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean insert(int data, int index) {
        if (index < 0 || index > size) {
            return false;
        }

        Node newNode = new Node();
        newNode.value = data;
        if (head==null) {
            head = tail = newNode;
        } else if (index == size){
            tail.next = newNode;
            newNode.next=null;
            tail=newNode;
        } else {
            Node currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
        return true;
    }

    public Node get(int index) {
        if (head==null) {
            System.out.println("SLL is empty");
            return new Node();
        } else if (index >= size || index < 0) {
            System.out.println("Index is out of bound");
            return new Node();
        } else {
            Node currentNode = head;
            for (int i = 1; i <= index ; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }

    public Node pop() {
        if (head == null) {
            System.out.println("The SLL does not exist");
            return null;
        } else if (size==1) {
            System.out.println("Deleting last node");
            Node toDelete = head;
            head = tail = null;
            size--;
            return toDelete;
        } else {
            System.out.println("BEFORE: size=" + size);
            Node currentNode = head;
            for (int i = 1; i < size-1; i++) {
                currentNode = currentNode.next;
            }
            Node toDelete = tail;
            currentNode.next = null;
            tail = currentNode;
            size--;
            System.out.println("AFTER: size=" + size);
            return toDelete;
        }
    }

    public String rotate(int number) {
        if(number < 0 || number >= size) {
            return "index out of box";
        }
        // 10, 20, 30, 40
        if (head==null) {
            return "empty SLL";
        } else {
            Node currentNode = head;
            for (int i = 1; i <= number ; i++) {
                currentNode = head.next;
                tail.next = head;
                tail=head;
                tail.next = null;
                head = currentNode;
            }
            return "DONE";
        }
    }

    public boolean set(int index, int value) {
        if (head==null) {
            System.out.println("SLL is empty");
            return false;
        } else if (index >= size || index < 0) {
            System.out.println("Index is out of bound");
            return false;
        } else {
            Node currentNode = head;
            for (int i = 1; i <= index ; i++) {
                currentNode = currentNode.next;
            }
            currentNode.value = value;
            return true;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index>size-1) {
            System.out.println("Index is out of bound");
            return null;
        }

        Node result=null;
        if (head==null) {
            System.out.println("SLL is empty");
        } else if (index==0) {
        } else if (index==size-1) {
            Node currentNode = head;
            for (int i = 1; i < size-1 ; i++) {
                currentNode = currentNode.next;
            }
            result = currentNode.next;
            tail = currentNode;
            currentNode.next = null;
        } else {
            Node currentNode = head;
            for (int i = 1; i < index ; i++) {
                currentNode = currentNode.next;
            }
            result = currentNode.next;
            currentNode.next = result.next;
        }

        if (size==0) {
            head=tail=null;
        }

        return result;
    }

    class Node {
        public int value;
        public Node next;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.push(5);  // Success
        singlyLinkedList.push(10);  // Success
        singlyLinkedList.push(15);  // Success
        singlyLinkedList.push(20);  // Success
        singlyLinkedList.push(25) ; // Success
        System.out.println(singlyLinkedList.remove(2).value); // 15
        singlyLinkedList.remove(100); // null
        System.out.println(singlyLinkedList.size); // 4
        System.out.println(singlyLinkedList.remove(2).value);   // 5
        System.out.println(singlyLinkedList.head.value );  // 10
        System.out.println(singlyLinkedList.head.next.value ); // 20
        System.out.println(singlyLinkedList.head.next.next.value);  // 25
    }
}