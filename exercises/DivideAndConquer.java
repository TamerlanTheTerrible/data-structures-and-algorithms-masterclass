package exercises;

/**
 * Created by Temurbek Ismoilov on 13/02/23.
 */

public class DivideAndConquer {

    /*
    countZeroes([1,1,1,1,0,0]) # 2
    countZeroes([1,0,0,0,0]) # 4
    countZeroes([0,0,0]) # 3
    countZeroes([1,1,1,1]) # 0
    */
    public static int countZeroes(int[] array) {
        int left = 0;
        int right = array.length;
        while (left <= right) {
            int middle = (int) (left+right)/2;
            if (array[middle]==1) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return array.length - left;
    }

    /*
    sortedFrequency([1, 1, 2, 2, 2, 2, 3], 2) # 4
    sortedFrequency([1, 1, 2, 2, 2, 2, 3], 3) # 1
    sortedFrequency([1, 1, 2, 2, 2, 2, 3], 4) # -1
    sortedFrequency([], 4) # -1
     */
    public static int sortedFrequency(int[] arr, int num) {
        if (num < arr[0] || num > arr[arr.length-1]) {
            return -1;
        }

        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int middle = (int) (left+right)/2;
            if (arr[middle]<num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        final int start = arr.length - left;
        left = 0;
        right = arr.length;
        while (left <= right) {
            int middle = (int) (left+right)/2;
            if (arr[middle]<num+1) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        final int end = arr.length - left;
        return start-end;
    }

    // [11, 12, 13, 14, 15, 16, 3, 5, 7, 9], 16
    public static int findRotatedIndex(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int middle = 0;
        if (right>0 && arr[left] >= arr[right]) {
            middle = (int) Math.floor((left + right) / 2);
            while (arr[middle] <= arr[middle + 1]) {
                if (arr[left] <= arr[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
                middle = (int) Math.floor((left + right) / 2);
                if (middle+1 > arr.length-1) {
                    break;
                }

            }
            if (num >= arr[0] && num <= arr[middle]) {
                left = 0;
                right = middle;
            } else {
                left = middle + 1;
                right = arr.length - 1;
            }

        }
        while (left <= right) {
            middle = (int) Math.floor((left + right) / 2);
            if (num == arr[middle]) {
                return middle;
            }
            if (num > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3};
        System.out.println(sortedFrequency(arr, 5));
    }
}
