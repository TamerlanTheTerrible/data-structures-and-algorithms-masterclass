package tree;

import java.util.Objects;

/**
 * Created by Temurbek Ismoilov on 23/01/23.
 */

public class BinaryHeap {
    private int[] arr;
    private int sizeOfTree;

    public BinaryHeap(int size) {
        this.arr = new int[size+1];
        this.sizeOfTree = 0;
    }

    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

    public int size() {
        return sizeOfTree;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("tree is empty");
            return null;
        }
        return arr[1];
    }

    public void levelOrder() {
        for (int i = 1; i < sizeOfTree+1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index/2;
        if (index <= 1) {
            return;
        }

        if (Objects.equals(heapType, "Min") && arr[index] < arr[parent]) {
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
        } else if (Objects.equals(heapType, "Max") && arr[index] > arr[parent]) {
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
        }

        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String heapType) {
        arr[++sizeOfTree] = value;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println(value + " inserted");
    }
}

