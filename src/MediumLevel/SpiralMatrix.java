package MediumLevel;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        List<Integer> list = spiralMatrixClockwiseMove(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(list.toString());
    }

    public static List<Integer> spiralMatrixClockwiseMove(int[][] matrix){
        int topRow = 0;
        int bottomRow = matrix.length-1; // row lengths from first row to end row
        int leftColumn = 0;
        int rightColumn = matrix[0].length-1; //total columns by counting from 1st to end column// in every row we have same columns so we took first row of matrix only for counting no of columns

        List<Integer> response = new ArrayList();
        if(matrix.length == 0) return response;
        int totalElements = matrix.length * matrix[0].length;
        int count=0;
        while(count<totalElements){
            //Top wall traverse:( row fixes , column changes)
            for(int i=leftColumn;i<=rightColumn && count<totalElements;i++ ){  // count condition everywhere in each loop as very insider box is not necessary can have 4 walls so we are using element count to avoid duplicate printing in inner box
                response.add(matrix[topRow][i]);
                count++;
            }
            topRow++;
            //Right Wall traverse:( column fixed, row changes)
            for(int j = topRow;j<=bottomRow && count<totalElements;j++){
                response.add(matrix[j][rightColumn]);
                count++;
            }
            rightColumn--;
            //bottom wall traverse:(row fixed, column changes)
            for (int k = rightColumn; k >= leftColumn && count<totalElements; k--) {
                response.add(matrix[bottomRow][k]);
                count++;
            }
            bottomRow--;

            //left wall traverse:(column fixed, row changes)
            for(int l=bottomRow;l>=topRow && count<totalElements;l--){
                response.add(matrix[l][leftColumn]);
                count++;
            }
            leftColumn++;
        }
        return response;
    }

}
