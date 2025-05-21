package matrix;

import java.util.Arrays;

public class TransposeOfMatrix {

    private static int[][] transpose(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] result = new int[cols][rows];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result[j][i] = arr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        System.out.println(Arrays.deepToString(transpose(mat)));
    }
}
