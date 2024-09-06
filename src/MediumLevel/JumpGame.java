package MediumLevel;

public class JumpGame {

    public static void main(String[] args) {
        boolean reachOrNot = jumpGame(new int[]{1,1,2,5,2,1,0,0,1,3});
    }

    //if there are no zeroes we will for sure reach at last as atleast we can jump minimin one step if no zeros in array
    // Solution: iterate from backwards and see if element can reach goal , if yes  then set it equal to goal node and continue
    public static boolean jumpGame(int [] ar){
        int finalPosition = ar.length -1;
        for( int i = ar.length -2; i>=0; i--){
            if(i +ar[i] >= finalPosition){
                finalPosition = i;
            }
        }
        return finalPosition == 0;
    }
}
