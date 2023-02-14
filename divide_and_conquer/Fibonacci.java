package divide_and_conquer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Temurbek Ismoilov on 02/02/23.
 */

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n==1)
            return 0;
        else if (n==2)
            return 1;
        else
            return fibonacci(n-2) + fibonacci(n-1);
    }

    //dynamic programming top-down
    public static int fibonacciMemo(int n, HashMap<Integer, Integer> memo) {
        if (n==1)
            return 0;
        if (n==2)
            return 1;

        if (!memo.containsKey(n)) {
            memo.put(n, fibonacciMemo(n-1, memo) + fibonacciMemo(n-2, memo));
        }
        return fibonacci(n-2) + fibonacci(n-1);
     }

    //dynamic programming buttom-up
    public static int fibonacciTabulation(int n) {
        ArrayList<Integer> tb = new ArrayList<>();
        tb.add(0);
        tb.add(1);
        for (int i = 2; i < n; i++) {
            int n1 = tb.get(i-1);
            int n2 = tb.get(i-2);
            tb.add(n1+n2);
        }

        return tb.get(n-1);
    }
}
