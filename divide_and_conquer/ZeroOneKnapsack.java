package divide_and_conquer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Temurbek Ismoilov on 02/02/23.
 */

public class ZeroOneKnapsack {

    public static int knapSack(int[] profits, int[] weights, int capacity) {
        return knapSack(profits, weights, capacity, 0);
    }

    private static int knapSack(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
            return 0;
        }

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapSack(profits, weights, capacity-weights[currentIndex], currentIndex+1);

        }
        int profit2 = knapSack(profits, weights, capacity, currentIndex+1);
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] profits = new int[] {31,26,17,72};
        int[] weights = new int[] {3,1,2,5};
        System.out.println(knapSack(profits, weights, 7));
    }

}
