package MediumLevel;

public class SetMatrixZero {

    public static void main(String args[]){
        makeCorrespondingColAndRowZeroIfZeroFound(new int [][]{{2,3},{4,5},{6,7}});
    }

    public static void  makeCorrespondingColAndRowZeroIfZeroFound(int [][] matrix){
        int n = matrix[0].length; // number of elements in each object represents number of columns
        System.out.println("col length"+n);
        int m = matrix.length;  // number of elements in a 2D matrix represents rows as we use number of objects to represent rows
        System.out.println("row length"+m);

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i] =1;
                    col[j] =1;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(row[i]== 1){
                for(int j=0;j<m;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<m;j++){
            if(col[j]==1){
                for(int i=0;i<n;i++){
                    matrix[i][j]=0;
                }
            }
        }

    }
}
