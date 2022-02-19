import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        //int[] shuffled = shuffle(new int[]{2,3,1,5,4,7},3);
        int[] shuffled = shuffle(new int[]{1,2,9,11,15,21,3,19},4);
        System.out.println("shuffled-----"+ Arrays.toString(shuffled));
    }

    public static int[] shuffle(int[]ar, int n){
        int[] newAr = new int [ar.length];

        int i=0;
        int j=n;
        int position = 0;
        while((i<n && j<=ar.length) ){
            newAr[position] = ar[i++];
            position++;
            newAr[position] = ar[j++];
            position++;

        }

        return newAr;



    }
}
