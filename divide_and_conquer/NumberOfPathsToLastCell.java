package divide_and_conquer;

/**
 * Created by Temurbek Ismoilov on 03/02/23.
 */

public class NumberOfPathsToLastCell {

    public static int numberOfPathsToLastCell(int[][] matrix, int totalCost) {
        return 1;
    }

    private static int numberOfPathsToLastCell(int[][] matrix, int costLeft, int x, int y) {
        return 1;
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{4,7,1,6},{5,7,3,9},{3,2,1,2},{7,1,6,3}};
        System.out.println(numberOfPathsToLastCell(M, 25));
    }
}
