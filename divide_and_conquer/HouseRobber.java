package divide_and_conquer;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Temurbek Ismoilov on 02/02/23.
 */

public class HouseRobber {
    //divide and conquer
    public static int houseRobber(int[] houses) {
        if (houses.length==0) {
            return 0;
        } else if (houses.length==1) {
            return houses[0];
        } else if (houses.length==2) {
            return Math.max(houses[0], houses[1]);
        }

        return Math.max(
                houses[0] + houseRobber(Arrays.copyOfRange(houses, 2, houses.length)),
                houseRobber(Arrays.copyOfRange(houses, 1, houses.length))
        );
    }

    //dynamic programming: top-down
    public static int houseRobberMemo(int[] houses, HashMap<Integer, Integer> memo) {
        final int length = houses.length;
        if (length ==0) {
            return 0;
        } else if (length ==1) {
            return houses[0];
        } else if (length ==2) {
            return Math.max(houses[0], houses[1]);
        } else {
            if (!memo.containsKey(length)) {
                memo.put(length,
                        Math.max(
                                houses[0] + houseRobberMemo(Arrays.copyOfRange(houses, 2, length), memo),
                                houseRobberMemo(Arrays.copyOfRange(houses, 1, length), memo)
                        )
                );
            }
            return memo.get(length);
        }
    }

    //dynamic programming: bottom-up
    public static int houseRobberTabular(int[] houses) {
        int dp[] = new int[houses.length + 2]; // '+1' to handle the zero house
        dp[houses.length] = 0; // if there are no houses, the thief can't steal anything
        for (int i = houses.length - 1; i >= 0; i--) {
            dp[i] = Math.max(houses[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        final int[] houses = {6, 7, 45, 30, 8, 55, 4, 7, 45, 30, 8, 55, 4, 7, 45, 30, 8, 55};
        System.out.println(houseRobber(houses));
        System.out.println(houseRobberMemo(houses, new HashMap<>()));
        System.out.println(houseRobberTabular(houses));
    }
}