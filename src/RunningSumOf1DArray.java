import java.util.Arrays;

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        runningSumOneDArray(new int[]{1,2,3,4,5});
    }

    //brute force using new array
    public static int[] runningSumOneDimensionalArray(int []ar){
            int [] runningSumAr =new int[ar.length];
            for(int i=0;i<ar.length;i++){
                runningSumAr[i]+=ar[i];
            }
            return runningSumAr;
    }

    //alter existing array by adding prev and current index and return it
    public static int[] runningSumOneDArray(int[]ar){
        for(int i=1;i<ar.length;i++){
            ar[i] = ar[i]+ar[i-1];
        }
        System.out.println(Arrays.toString(ar));
        return ar;
    }
}
