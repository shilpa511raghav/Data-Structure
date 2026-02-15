package MediumLevel;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
          int output = maxAreaOfIsland(grid);
        System.out.println(output);
    }

    public static int maxAreaOfIsland(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    maxArea =Math.max(maxArea,dfsReturnEachIslandArea(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    public static int dfsReturnEachIslandArea(int[][] grid,int r, int c){

        if(r<0|| r>=grid.length|| c<0||c >=grid[0].length || grid[r][c]< 1) return 0;
        grid[r][c] = -1; // marked visited
        int area = 1;

            area+= dfsReturnEachIslandArea(grid,r+1,c);
            area+= dfsReturnEachIslandArea(grid,r-1,c);
            area+= dfsReturnEachIslandArea(grid,r,c+1);
            area+= dfsReturnEachIslandArea(grid,r,c-1);

        return area;
    }


    /*public static int dfsReturnEachIslandArea(int[][] grid,int r, int c){
        int[] dx= {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        if(r<0|| r<=grid.length|| c<0||c <=grid[0].length || grid[r][c]< 1) return 0;
        grid[r][c] = -1; // marked visited
        int area = 1;
        for(int i=0;i<4;i++){
            area+= dfsReturnEachIslandArea(grid,dx[i],dy[i]);
        }
        return area;
    }*/
}
 