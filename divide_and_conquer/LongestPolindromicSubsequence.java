package divide_and_conquer;

/**
 * Created by Temurbek Ismoilov on 02/02/23.
 */

public class LongestPolindromicSubsequence {

    public static void main(String[] args) {
        final String str = "ELRMENMET";
        System.out.println(lpd(str));
        System.out.println(lpdTopDown(str, 0, str.length()-1, new int[str.length()][str.length()]));
        System.out.println(lpdBottomUp(str));
    }

    public static int lpd(String str) {
        return lpd(str, 0, str.length()-1);
    }

    private static int lpd(String str, int i1, int i2) {
        if (i1 == i2) {
            return 1;
        }

        int c1=0;
        if (str.charAt(i1) == str.charAt(i2)) {
            c1 = 2 + lpd(str,i1+1, i2-1);
        }
        int c2 = lpd(str, i1, i2-1);
        int c3 = lpd(str, i1+1, i2);

        return Math.max(c1, Math.max(c2, c3));
    }

    private static int lpdTopDown(String str, int i1, int i2, int[][] matrix) {
        if (i1 == i2) {
            return 1;
        }

        if (matrix[i1][i2]==0) {
            int c1=0;
            if (str.charAt(i1) == str.charAt(i2)) {
                c1 = 2 + lpdTopDown(str,i1+1, i2-1, matrix);
            }
            int c2 = lpdTopDown(str, i1, i2-1, matrix);
            int c3 = lpdTopDown(str, i1+1, i2, matrix);

            matrix[i1][i2] = Math.max(c1, Math.max(c2, c3));
        }

        return matrix[i1][i2];
    }

    public  static int lpdBottomUp(String st) {
        int[][] dp = new int[st.length()][st.length()];
        for (int col = 0; col < st.length(); col++) {
            for (int row = st.length()-1; row >= 0; row--) {
                if (row > col) { // BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
                    dp[row][col] = 0;
                } else if (row == col) { // BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
                    dp[row][col] = 1;
                } else {
                    if (st.charAt(row) == st.charAt(col)) {
                        dp[row][col] = Math.max(2+dp[row + 1][col - 1], Math.max(dp[row][col - 1], dp[row + 1][col]));
                    } else {
                        dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
                    }
                }
            }
        }// end of loop
        return dp[0][st.length()-1];
    }// end of method

}
