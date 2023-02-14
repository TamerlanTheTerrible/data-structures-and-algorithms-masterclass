package divide_and_conquer;

/**
 * Created by Temurbek Ismoilov on 03/02/23.
 */

public class MinimumCostToLastCell {
    public static int minimumCostToLastCell(int[][] matrix) {
        return minimumCostToLastCell(matrix, matrix.length-1, matrix[0].length-1);
    }

    private static int minimumCostToLastCell(int[][] matrix, int x, int y) {
        if (x==0 && y== 0) {
            return matrix[0][0];
        }

        int currentCost = matrix[x][y];
        int costToUp = x!=0 ? currentCost + minimumCostToLastCell(matrix, x-1, y) : Integer.MAX_VALUE;
        int costTLeft = y!=0 ? currentCost + minimumCostToLastCell(matrix, x, y-1): Integer.MAX_VALUE;

        return Math.min(costToUp, costTLeft);
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{4,7,8,6,4},{6,7,3,9,2},{3,8,1,2,4},{7,1,7,3,7},{2,9,8,9,3}};
        System.out.println(minimumCostToLastCell(M));
    }
}
