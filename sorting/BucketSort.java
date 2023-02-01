package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Temurbek Ismoilov on 25/01/23.
 */

public class BucketSort {

    public static void sort(int[] arr) {
        //create buckets
        int numberOfBuckets = (int)Math.ceil(Math.sqrt(arr.length));
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
        //calc max value
        int maxValue = Integer.MIN_VALUE;
        for(Integer num: arr) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        //fill buckets
        for (int value: arr) {
            int bucketNum = (int) Math.ceil((float) value * numberOfBuckets / (float)maxValue);
            buckets[bucketNum-1].add(value);
        }
        //print buckets before sort
        printBuckets(buckets);
        for(ArrayList<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }

        //print buckets after sort
        printBuckets(buckets);

        int index=0;
        for(ArrayList<Integer> bucket: buckets) {
            for (Integer value: bucket) {
                arr[index] = value;
                index++;
            }
        }

        //print result
        System.out.println(Arrays.toString(arr));

    }

    public static void printBuckets(ArrayList<Integer>[] buckets) {
        for (ArrayList<Integer> bucket: buckets) {
            System.out.print(Arrays.toString(bucket.toArray()) + " ");
        }
        System.out.println();
    }
}
