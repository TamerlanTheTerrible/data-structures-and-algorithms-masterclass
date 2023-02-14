package greedy_algorhitm;

import java.util.Arrays;

/**
 * Created by Temurbek Ismoilov on 02/02/23.
 */

public class CoinChange {

    public static void coinChangeProblem(int[] coins, int N) {
        Arrays.sort(coins);
        int remainder = N;
        for (int i = coins.length-1; i > -1; i--) {
            while (coins[i] <= remainder) {
                System.out.print(coins[i] + " ");
                remainder = remainder - coins[i];
            }
            if (remainder == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5,10,20,50,10,1000};
        coinChangeProblem(coins, 2035);
    }
}
