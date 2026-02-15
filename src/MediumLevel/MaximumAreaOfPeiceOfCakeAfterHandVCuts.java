package MediumLevel;

import java.util.Arrays;

public class MaximumAreaOfPeiceOfCakeAfterHandVCuts {
    public static void main(String[] args) {
        //int response = maxAreaOfPieceOfCake(5, 4, new int[]{1, 2, 4}, new int[]{1, 3});
        //int response1 = maxAreaOfPieceOfCake(5, 4, new int[]{3,1}, new int[]{1});
        //int response2 = maxAreaOfPieceOfCake(5, 4, new int[]{3}, new int[]{3});
        int response3 = maxAreaOfPieceOfCake(1000000000, 1000000000, new int[]{2}, new int[]{2});
        //System.out.println(response);
        //System.out.println(response1);
        //System.out.println(response2);
        System.out.println(response3);

    }

    public static int maxAreaOfPieceOfCake(int h,int v, int[]horizontalCuts, int [] verticalCuts){
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH= Math.max(horizontalCuts[0],h-horizontalCuts[horizontalCuts.length-1]); // to cover 0 to hCut[0] piece and from hCuts length subtract last index of hCut
        int maxV = Math.max(horizontalCuts[0],v-verticalCuts[verticalCuts.length-1]); // to cover 0 to vCut[0] piece, and from vcuts length subtract last index of vcut
        for(int i=1;i< horizontalCuts.length;i++){
            maxH = Math.max(maxH, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        for(int j=1;j< verticalCuts.length;j++){
            maxV = Math.max(maxV, verticalCuts[j]-verticalCuts[j-1]);
        }
        return (int)((long)(maxV*maxH%1000000007));
    }
    
}
