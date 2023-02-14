package divide_and_conquer;

/**
 * Created by Temurbek Ismoilov on 10/02/23.
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "BAABAD";
        System.out.println(lps(s));
        System.out.println(lpsTopDown(s,0, s.length()-1, new String[s.length()][s.length()]));
    }

    public static String lps(String s) {
        return lps(s, 0, s.length()-1);
    }

    private static String lps(String s, int i, int j) {
        if (i>j) {
            return "";
        }
        if (i==j) {
            return String.valueOf(s.charAt(i));
        }

        if (s.charAt(i)==s.charAt(j)) {
            return s.charAt(i) + lps(s, i+1, j-1) + s.charAt(j);
        } else {
            String str1 = lps(s, i+1, j);
            String str2 = lps(s, i, j-1);
            return str1.length() > str2.length() ? str1 : str2;
        }
    }

    private static String lpsTopDown(String s, int i, int j, String[][] matrix) {
        if (i>j) {
            return "";
        }
        if (i==j) {
            return String.valueOf(s.charAt(i));
        }

        if (matrix[i][j] == null) {
            String res = "";
            if (s.charAt(i)==s.charAt(j)) {
                res = s.charAt(i) + lpsTopDown(s, i+1, j-1, matrix) + s.charAt(j);
            } else {
                String str1 = lpsTopDown(s, i+1, j, matrix);
                String str2 = lpsTopDown(s, i, j-1, matrix);
                res = str1.length() > str2.length() ? str1 : str2;
            }
            matrix[i][j] = res;
        }
        return matrix[i][j];
    }
}
