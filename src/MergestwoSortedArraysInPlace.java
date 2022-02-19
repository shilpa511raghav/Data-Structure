import java.util.Arrays;

public class MergestwoSortedArraysInPlace {
    public static void main(String[] args) {
        //merge(new int[]{1,3,4}, 6,new int[]{3,5,6},3);
        //int[] a1 = merge(new int[]{1,3,4,0,0,0}, 3,new int[]{3,5,6},3);
        int [] ar2 = mrgInPlace(new int[]{1,3,4,0,0,0,0}, 3,new int[]{1,2,3,6,},4);
        //System.out.println("a1--- = "+a1.toString());
        System.out.println("a2----- = "+ Arrays.toString(ar2));
    }


    public static int[] merge(int[] nums1, int m, int[] nums2, int n){
        // take 3 pointers
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        //merge in reverse order to avoid time complexity of iterations
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
        return nums1;
    }


    public static  int[] mergeCopy(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        int tail1 = m-1;
        int tail2 = n-1;

        while(tail1>=0 && tail2>=0){
            if(nums1[tail1]<nums2[tail2]){
                nums1[last] = nums2[tail2];
                last -=1;
                tail2-=1;
            }else{
               nums1[last] = nums1[tail1];
               last-=1;
                tail1-=1;
            }
        }

        while (tail2>=0){
            nums1[last] = nums2[tail2];
            tail2-=1;
            last-=1;
        }
        return nums1;
    }

    //day 8 feb practice
    public static int[] mrgInPlace(int[] nums1, int m , int nums2[], int n){
        int tail1 = m-1;
        int tail2 = n-1;
        int last = m+n-1;

        while(tail1>=0 && tail2 >=0){
            if(nums1[tail1] < nums2[tail2]){
                nums1[last] = nums2[tail2];
                last--;
                tail2--;
            }else{
                nums1[last] = nums1[tail1];
                last--;
                tail1--;
            }
        }
        while(tail2>=0){
            nums1[last] = nums2[tail2];
            tail2--;
            last--;
        }
        return nums1;
    }
}
