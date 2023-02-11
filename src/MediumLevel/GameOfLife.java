package MediumLevel;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        int [][] nextGenBoard = gameOfLifeOptimal(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
        System.out.println(Arrays.deepToString(nextGenBoard));
    }

    //Brute Force using extra board to make next gen of each cell
    public static int[][] gameOfLifeExtraSpaceBruteForce(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        int[][] copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copyBoard[i][j] = board[i][j];
                int dx[] = {0, 1, 1, -1, -1, -1, 0, 1,};
                int dy[] = {1, 0, 1, 1, 0, -1, -1, -1};
                int liveCount = 0;
                for (int k = 0; k < 8; k++) {
                    int curRow = i + dx[k];
                    int curCol = j + dy[k];
                    if (isEachCellInBounds(curRow, curCol, R, C) && (board[curRow][curCol]) == 1) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 1) {
                    if (liveCount == 2 || liveCount == 3) {
                        copyBoard[i][j] = 1;
                    } else if (liveCount < 2 || liveCount > 3) {
                        copyBoard[i][j] = 0;
                    }
                } else {
                    if (liveCount == 3) {
                        copyBoard[i][j] = 1;
                    }

                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = copyBoard[i][j];
            }
        }

        return board;
    }

    public static boolean isEachCellInBounds(int curRow, int curCol, int row, int col) {
        return (curRow >= 0 && curCol >= 0 && curRow < row && curCol < col);
    }

    // two loop to loop over each cell of matrix, and then from each cell find all direction counts of 1 (live cell)
    // use coordinate for 8 directions and then after live count of each direction of all cells.
    //take care of boundary conditions as well while calculating live count from each cell
    // check to make a live cell dead use -1 so that next any cell will have that direction by taking absolute vale of that cell which we make dead
    // use 2 for making dead cell live so that further if board has vale >0 then we can make them live i.e
    public static  int [][] gameOfLifeOptimal(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        int dx[] = {0, 1, 1, -1, -1, -1, 0, 1,};
        int dy[] = {1, 0, 1, 1, 0, -1, -1, -1};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int liveCount = 0;
                for (int k = 0; k < 8; k++) {
                    int curRow = i + dx[k];
                    int curCol = j + dy[k];
                    if (curRow >= 0 && curRow < R && curCol >= 0 && curCol < C && (Math.abs(board[curRow][curCol]) == 1)) {
                        liveCount++;
                    }
                }

                if(board[i][j]==1){
                    if(liveCount <2 || liveCount>3){
                        board[i][j] = -1;
                    }else if(liveCount==2 || liveCount ==3){
                        board[i][j] = 2;
                    }
                }
                    if(board[i][j]==0 && liveCount == 3 ){
                        board[i][j] =2;
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                board[i][j] = board[i][j] >0 ?1 :0;
            }
        }
        return board;
    }



}
