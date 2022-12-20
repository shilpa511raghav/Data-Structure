import java.sql.Array;
import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        //productOfArrayExceptSelfWithoutLongDivision(new int[]{1,2,3,4});
        productSelfOptimal(new int[]{1,2,3,4});
    }


    //Brute Force -
    public static int[] productOfArrayExceptSelfWithoutLongDivision(int []ar){
        int [] leftAr = new int[ar.length];
        int [] rightAr = new int[ar.length];
        int [] outputAr = new int [ar.length];
        leftAr[0] = ar[0];
        int len = ar.length;
        rightAr[ar.length-1] = ar[ar.length-1];

        for(int i=1;i<ar.length;i++){
            leftAr[i] = ar[i]*leftAr[i-1];
        }
        for(int j= ar.length-2;j>=0;j--){
            rightAr[j] = ar[j]*rightAr[j+1];
        }
        outputAr[0] = rightAr[1];
        for(int k=1;k<ar.length-1;k++){
            outputAr[k] = leftAr[k-1] * rightAr[k+1];
        }
        outputAr[len-1] = leftAr[len-2];
        return outputAr;
    }


    public static int[] productSelf(int ar[]){
        int len = ar.length;
        int[] leftAr = new int[len];
        int[] rightAr = new int [len];
        int[] outputAr = new int [len];

        leftAr[0] = ar[0];
        for (int i=1;i<len;i++){
            leftAr[i] = ar[i]* leftAr[i-1];
        }
        rightAr[len-1] = ar[len-1];
        for(int j=len-2;j>=0;j--){
            rightAr[j] = ar[j]*rightAr[j+1];
        }
        outputAr[0] = rightAr[1];
        for(int k=0;k<len;k++){
            outputAr[k] = leftAr[k-1] * rightAr[k+1];
        }
        outputAr[len-1] = leftAr[len];
        return outputAr;
    }

    public static int[] productSelfOptimal(int[]ar){
        int len = ar.length;
        int[] outputAr = new int [len];
        int product;
        outputAr[0] = ar[0];
        for(int i=1;i< len;i++){
            outputAr[i] = ar[i-1] * outputAr[i-1];
        }
        int suffixProduct = 1;
        for(int j=len-1;j>=0;j--){
            outputAr[j] = outputAr[j] * suffixProduct;
            suffixProduct = suffixProduct * ar[j];
        }
        System.out.println(Arrays.toString(outputAr));
        return outputAr;
    }
}
