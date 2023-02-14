package divide_and_conquer;

/**
 * Created by Temurbek Ismoilov on 02/02/23.
 */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        final String str1 = "ABCBDAB";
        final String str2 = "BDCABA";
        System.out.println(lcs(str1, str2));
        System.out.println(lcsTopDown(str1, str2));
        System.out.println(lcsBottomUp(str1, str2));
    }

    public static int lcs(String str1, String str2) {
        return lcs(str1, str2, 0, 0);
    }

    private static int lcs(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2== s2.length()) {
            return 0;
        }

        int c1=0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            c1 = 1 + lcs(s1, s2 ,i1+1, i2+1);
        }
        int c2 = lcs(s1, s2 ,i1, i2+1);
        int c3 = lcs(s1, s2 ,i1+1, i2);

        return Math.max(c1, Math.max(c2, c3));
    }


    private static int myLcs(char[] str1, char[] str2, int i1, int i2) {
        if (i1 == str1.length || i2== str2.length) {
            return 1;
        }

        if (str1[i1] == str2[i2]) {
            return 1 + myLcs(str1, str2, i1+1, i2+1);
        } else {
            int tempInd= i2;
            while(true) {
                tempInd++;
                if (tempInd == str2.length) {
                    break;
                }
                if (str1[i1] == str2[tempInd]) {
                    return 1 + myLcs(str1, str2, i1+1, tempInd+1);
                }
            }

            tempInd = i1;
            while(true) {
                tempInd++;
                if (tempInd == str1.length) {
                    break;
                }
                if (str1[tempInd] == str2[i2]) {
                    return 1 + myLcs(str1, str2, tempInd+1, i2+1);
                }
            }

            return myLcs(str1, str2, tempInd+1, i2+1);
        }
    }

    private static int lcsTopDown(String s1, String s2) {
        final int[][] matrix = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                matrix[i][j]=-1;
            }
        }
        return lcsTopDown(s1, s2, 0, 0, matrix);
    }

    private static int lcsTopDown(String s1, String s2, int i1, int i2, int[][] matrix) {
        if (i1 >= s1.length() || i2>= s2.length()) {
            return 0;
        }

        if (matrix[i1][i2] == -1) {
            int c1=0;
            if (s1.charAt(i1) == s2.charAt(i2)) {
                c1 = 1 + lcsTopDown(s1, s2 ,i1+1, i2+1, matrix);
            }
            int c2 = lcsTopDown(s1, s2 ,i1, i2+1, matrix);
            int c3 = lcsTopDown(s1, s2 ,i1+1, i2, matrix);
            matrix[i1][i2] = Math.max(c1, Math.max(c2, c3));
        }

        return matrix[i1][i2];
    }

    public static int lcsBottomUp(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length(); i >= 1; i--) {

            for (int j = s2.length(); j >= 1; j--) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i-1][j-1] =  Math.max((1 + dp[i][j]), Math.max(dp[i][j-1], dp[i-1][j]));
                }
                else {
                    dp[i-1][j-1] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }//end of inner loop
        }//end of loop
        return dp[0][0];
    }//end of method

}
