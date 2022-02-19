import java.util.Arrays;

public class RemoveEachOccurenceOfInputValue {

    public static void main(String[] args) {
        int count = removeElement(new int[]{2,1,1,3,2,5,2,6,2,2},2);
        //int count = removeElement(new int[]{3,2,2,3},3);
        //System.out.println("count============"+count);

    }

    /*public static int removeElement(int[]ar,int val){
        int i =0;
        for(int j=0;j<ar.length;j++){
            if(ar[j] != val){
                ar[i] = ar[j];
                i++;
            }
            System.out.println(ar[i]);
        }
        System.out.println(Arrays.toString(ar));
        return i;
    }*/


    public static int removeElement(int[]ar, int target){
        int i =0;
        for (int j=0;j<ar.length;j++){
            if(ar[j]!= target){
                ar[i] = ar[j];
                i++;
            }
        }
        return i;
    }
}
