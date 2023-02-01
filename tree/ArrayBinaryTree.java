package tree;

import java.util.Objects;

/**
 * Created by Temurbek Ismoilov on 22/01/23.
 */

public class ArrayBinaryTree {
    private String[] array;
    private int lastUsedIndex;

    public ArrayBinaryTree(int size) {
        this.array = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Tree created with size " + size);
    }

    public boolean isFull() {
        return array.length - 1 == lastUsedIndex;
    }

    public void insert(String value) {
        if (isFull()) {
            System.out.println("Tree is full");
        } else {
            array[++lastUsedIndex] = value;
            System.out.println(value + " inserted at index " + lastUsedIndex);
        }
    }

    public void preOder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(array[index] + " ");
        preOder(index *2);
        preOder(index *2 + 1);
    }

    public void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        inOrder(index *2);
        System.out.print(array[index] + " ");
        inOrder(index *2 + 1);
    }

    public void postOder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        postOder(index *2);
        postOder(index *2 + 1);
        System.out.print(array[index] + " ");
    }

    public void leverOrder() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int search(String value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String value) {
        int location = search(value);
        if (location == -1) {
            System.out.println(value + " not found");
        } else {
            array[location] = array[lastUsedIndex];
            array[lastUsedIndex] = null;
            lastUsedIndex--;
            System.out.println(value + " deleted");
        }
    }

    public void deleteTree() {
        try {
            array = null;
            System.out.println("tree deleted");
        } catch (Exception e) {
            System.out.println("error while deleting tree");
        }
    }
}
