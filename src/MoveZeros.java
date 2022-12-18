import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] res = moveZeros(new int[]{0,1,0,3,12});
        System.out.println(Arrays.toString(res));
    }

    //bruteforce approach: create one array of same length and move all non zeros integers in new array
    public static int[] moveZeroes(int []ar){
        int [] output  = new int[ar.length];
        int j=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]!= 0){
                output[j] = ar[i];
                j++;
            }
        }
       return output;
    }

    //In-place approach without new memory ,
    // take two pointers left and right and move left pointer conditionally based of ,
    // if right pointer value non zero then swap both index values and move left pointer only then
    public static int[] moveZeros(int[]ar){
        int l=0;
        for(int r=0;r<ar.length;r++){
            if(ar[r]!=0){
                //Swap values add both first x= x+y then subtract x= x-y and then y = x-y;
                ar[l] = ar[l]+ ar[r];
                ar[r] = ar[l]-ar[r];
                ar[l] = ar[l]-ar[r];
                l++;
            }
        }
        return ar;
    }

}
