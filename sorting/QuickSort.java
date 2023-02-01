package sorting;

/**
 * Created by Temurbek Ismoilov on 25/01/23.
 */

public class QuickSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length-1);
    }

    private static void sort(int[] arr, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int pivot = partition(arr, firstIndex, lastIndex);
            sort(arr, firstIndex, pivot-1);
            sort(arr, pivot, lastIndex);
        }
    }

    private static int partition(int[] array, int firstIndex, int lastIndex) {
        int index = firstIndex-1;
        for (int i = firstIndex; i <= lastIndex; i++) {
            if (array[i] <= array[lastIndex]) {
                index++;
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

        return index;
    }


    public static void printArray(int []array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"  ");
        }
    }
}