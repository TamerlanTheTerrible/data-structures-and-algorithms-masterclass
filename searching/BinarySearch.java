package searching;

import java.util.Arrays;

/**
 * Created by Temurbek Ismoilov on 25/01/23.
 */

public class BinarySearch {

    public static int search(int[] arr, int value) {
        return search(arr, 0, arr.length, value);
    }

    private static int search(int[] arr, int start, int end, int value) {
        int mid = (start+end)/2;
        if (start > arr.length-1 || end == 0) {
            return -1;
        }

        if (value > arr[mid]) {
            return search(arr, mid+1, end, value);
        } else if (value < arr[mid]){
            return search(arr, start, mid, value);
        } else {
            return mid;
        }

    }
}
