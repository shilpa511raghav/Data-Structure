import java.util.Arrays;

public class SqauresOfSortedArray {
    public static void main(String[] args) {

        int[] output = squaresOfSortedArray(new int[]{-4,-1,0,3,10});
        System.out.println(output);
    }

    //In place and  time complexity = nlogn as arrays.sort take nlogn
    //Space complexity = O(N) as no new space used
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    //take two pointer left and right and compare both square and then shift that number whoz square is larger to the end of new array
    public static int[] squaresOfSortedArray(int ar[]){
        int[] res = new int[ar.length];
        int l=0,r=ar.length-1,k=ar.length-1;
        while(l<=r){
            if((ar[l]*ar[l]) > (ar[r]* ar[r])){
                res[k] = ar[l]*ar[l];
                l++;
            }else if((ar[l]*ar[l])<= (ar[r]* ar[r])){
                res[k] = ar[r]* ar[r];
                r--;
            }
            k--;
        }
        return res;
    }
}
