package MediumLevel;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] res= findNextPermutation(new int[]{1,2,3});
        int [] res2= findNextPermutation(new int []{3,2,1});// if number is already big then reverse complete array to find next lexicographical sequence
        int []res3= findNextPermutation(new int []{1,1,5});
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));

    }

    //Steps:
    // find point of change: start from end and find first decreasing sequence while traversing from end  i.e (ar[i] <ar[i+1])
    // find the number for substitution and perform swap
    // rearrange the remaining array after above swapping step

    public static int[] findNextPermutation(int ar[]){

        int i= ar.length-2;
        //find number to change (point of change)
        while(i>=0 && ar[i]>= ar[i+1]){
            i--;
        }
        //find number to swap with
        if(i>=0){
            int j= ar.length-1;
            while(j>=0 && ar[i]>=ar[j]){
                j--;
            }
          swap(ar,i,j);
        }
        //reverse
        reverse(ar,i+1);
        return ar;
    }

    //Swap two numbers
    public static void swap(int[] ar, int i, int j ){
        ar[i] = ar[i]+ ar[j];
        ar[j] = ar[i]-ar[j];
        ar[i] = ar[i] - ar[j];
    }

    public static void reverse(int ar[], int start){
        int end = ar.length-1;
        while(start< end){
            swap(ar,start,end);
                start++;
                end--;
        }
    }
}



