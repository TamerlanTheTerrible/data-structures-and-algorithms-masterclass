package divide_and_conquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Temurbek Ismoilov on 06/02/23.
 */

public class NumberFactor {
    /* given N, find the number of ways to express N as sum of 1,3,4 */
    //divide and conquer
    public static int numberFactor(int n) {
        if (n==0 || n==1 || n==2) {
            return 1;
        }
        if (n==3) {
            return 2;
        }
        return numberFactor(n-1) + numberFactor(n-3) + numberFactor(n-4);
    }

    //dynamic programming: top-down
    public static int numberFactorMemo(int n, HashMap<Integer, Integer> memo) {
        if (n==0 || n==1 || n==2) {
            return 1;
        } else if (n==3) {
            return 2;
        } else {
            if (!memo.containsKey(n)) {
                memo.put(n,
                        numberFactorMemo(n-1, memo)
                                + numberFactorMemo(n-3, memo)
                                + numberFactorMemo(n-4, memo)
                );
            }
            return memo.get(n);
        }
    }

    //dynamic programming: bottom-up
    public static int numberFactorTabulation(int n) {
        ArrayList<Integer> tab = new ArrayList<>(List.of(1, 1, 1, 2));
        for (int i = 4; i <=n; i++) {
            tab.add(
                    tab.get(i-1) + tab.get(i-3) + tab.get(i-4)
            );
        }
        return tab.get(n);
    }

    public static void main(String[] args) {
//        System.out.println(numberFactor(50)); //1851358561
        System.out.println(numberFactorMemo(50, new HashMap<>()));
        System.out.println(numberFactorTabulation(50));
    }
}
