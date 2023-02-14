package exercises.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Temurbek Ismoilov on 08/02/23.
 */

public class LongestRepeatedSubSeq {
    public int findLongestRepeatingSubSeq(String str) {
        return findLongestRepeatingSubSeq(str, 0,1, new ArrayList<Integer[]>());
    }

    private int findLongestRepeatingSubSeq(String str, int i1, int i2, ArrayList<Integer[]> list) {
        if (i2 == str.length()) {
            i1++;
            if (!list.isEmpty() && i1 == list.get(list.size()-1)[1]) {
                i1++;
            }
            i2=i1+1;
        }

        if (i1 >= str.length()-1) {
            return 0;
        }

        if (str.charAt(i1) == str.charAt(i2)) {
            list.add(new Integer[]{i1,i2});
            return 1+ findLongestRepeatingSubSeq(str, i1+1, i2+1, list);
        } else {
            return findLongestRepeatingSubSeq(str, i1, i2+1, list);
        }
    }

    public static void main(String[] args) {
        LongestRepeatedSubSeq lrs = new LongestRepeatedSubSeq();
        System.out.println(lrs.findLongestRepeatingSubSeq("ATAKTGGA"));
    }
}
