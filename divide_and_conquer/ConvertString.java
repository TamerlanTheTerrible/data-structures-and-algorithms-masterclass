package divide_and_conquer;

import java.util.HashMap;

/**
 * Created by Temurbek Ismoilov on 07/02/23.
 */

public class ConvertString {

    public static int findMinOperations(String str1, String str2, int i1, int i2) {
        if (i1 == str1.length()) {
            return str2.length() - i2;
        }
        if (i2 == str2.length()) {
            return str1.length() - i1;
        }
        if (str1.charAt(i1) == str2.charAt(i2)) {
            return findMinOperations(str1, str2, i1+1, i2+1);
        } else {
            int deleteOp = 1 + findMinOperations(str1, str2, i1, i2+1);
            int insertOp = 1 + findMinOperations(str1, str2, i1+1, i2);
            int replace = 1 + findMinOperations(str1, str2, i1+1, i2+1);
            return Math.min(deleteOp, Math.min(insertOp, replace));
        }
    }

    public static int findMinOperationsTopDown(String str1, String str2, int i1, int i2, int[][] matrix) {
        if (i1 == str1.length()) {
            return str2.length() - i2;
        }
        if (i2 == str2.length()) {
            return str1.length() - i1;
        }
        if (matrix[i1][i2] == 0) {
            int res = 0;
            if (str1.charAt(i1) == str2.charAt(i2)) {
                res = findMinOperationsTopDown(str1, str2, i1+1, i2+1, matrix);
            } else {
                int deleteOp = 1 + findMinOperationsTopDown(str1, str2, i1, i2+1, matrix);
                int insertOp = 1 + findMinOperationsTopDown(str1, str2, i1+1, i2, matrix);
                int replace = 1 + findMinOperationsTopDown(str1, str2, i1+1, i2+1, matrix);
                res = Math.min(deleteOp, Math.min(insertOp, replace));
            }
            matrix[i1][i2] = res;
        }
        return matrix[i1][i2];
    }

    public static int findMinOperationsBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i1 = 0; i1 <= s1.length(); i1++) // if we have reached the end of s1, then insert all the remaining characters of s2
            dp[i1][0] = i1;

        for (int i2 = 0; i2 <= s2.length(); i2++) // if we have reached the end of s2, then delete all the remaining characters of s1
            dp[0][i2] = i2;

        for (int i1 = 1; i1 <= s1.length(); i1++) {
            for (int i2 = 1; i2 <= s2.length(); i2++) { // If the strings have a matching character, recursively match for the remaining lengths.
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                else {
                    final int delete = dp[i1 - 1][i2];
                    final int insert = dp[i1][i2 - 1];
                    final int replace = dp[i1 - 1][i2 - 1];
                    dp[i1][i2] = 1 + Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }

    public static void main(String[] args) {
        String str1 = "table";
        String str2 = "tbres";
        System.out.println(findMinOperations(str1, str2, 0, 0));
        System.out.println(findMinOperationsTopDown(str1, str2, 0, 0, new int[str1.length()][str2.length()]));
    }
}
