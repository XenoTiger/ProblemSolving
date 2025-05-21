package matrix;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    /*
    A lucky number is a number that satisfies two conditions:
    It is the minimum in its row.
    It is the maximum in its column.
     */

    private static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int minVal = matrix[i][0];
            int minCol = 0;

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    minCol = j;
                }
            }

            boolean isLucky = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minCol] > minVal) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                luckyNumbers.add(minVal);
            }
        }

        return luckyNumbers;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 9, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Lucky Numbers: " + luckyNumbers(matrix));
    }
}
