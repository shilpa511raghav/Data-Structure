package MediumLevel;

public class RotateImageby90DegreeClockWise {
    public static void main(String[] args) {
        rotateImageBy90DegreeClockwise(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    //Two steps: make transpose move in upper triangle to avoid swapping twice(swapping of rows with columns i.e swapp 01 with 10 index , ) and then reverse each row after transpose
    public static void rotateImageBy90DegreeClockwise(int[][]matrix){
        //Transpose
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j< matrix.length;j++){  // here we are starting loop from j=i not from zero
                //swapping of row with column for transpose but in upper triangle (with main diagonal)
                int temp = matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = temp;
            }

            //Reverse each row now : outer loop for each row and a while loop inside for each column at first row until complete row is not reversed
            for(int k=0;k<matrix.length;k++){
               int leftIndex = 0;
               int rightIndex = matrix[i].length-1;
               while(leftIndex<rightIndex){
                   int temp = matrix[k][leftIndex];
                   matrix[k][leftIndex] = matrix[k][rightIndex];
                   matrix[k][rightIndex] = temp;
                  leftIndex++;
                  rightIndex--;
               }
            }
        }
    }

}
