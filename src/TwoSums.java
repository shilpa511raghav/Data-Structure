import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static void main(String[] args) {
        //int[] output  = tSums(new int[]{2, 7, 11, 15},9);
        //int[] output  = tSums(new int[]{3,3},6);
        //int[] output  = tSums(new int[]{8,2,4},5);
        int[] output = tSums(new int[]{2, 4, 7, 9}, 16);
        System.out.println("output====" + Arrays.toString(output));

        //int[] output2= twoSumsUsingHashMap(new int[]{2,4,7,9},9);
        //int[] output2= twoSumsUsingHashMap(new int[]{2, 7, 11, 15},26);
        int[] output2 = twoSumsUsingHashMap(new int[]{3, 3}, 6);
        System.out.println("output2===" + Arrays.toString(output2));

        int[] output3 = twoSumsTwoPointersTechnique(new int[]{2, 7, 11, 15}, 26);
        System.out.println("output3======" + Arrays.toString(output3));

    }

    //2 loops-
    public static int[] tSums(int[] ar,int target){
        for(int i=0;i<ar.length;i++){
            for(int j=0;j<ar.length;j++){
                if(i!=j){
                    if(ar[i]+ar[j]== target){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return new int[2];
    }

    public static int[] twoSums(int[] nums, int target) {
        int[] outputArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]) == target) {
                        outputArray[0] = i;
                        outputArray[1] = j;
                    }
                    break;
                }
            }
        }


        return outputArray;
    }

    //When array is sorted in ascending order then only this below-  two pointer technique is applicable
    public static int[] twoSumsTwoPointersTechnique(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[2];
    }

    public static int[] twoSumsWithMapLongSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(target - nums[j])) {
                return new int[]{j, map.get(nums[j])};
            }
        }
        return new int[2];
    }


    public static int[] twoSumsUsingHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }


    public static int[] tsums2pointer(int[] ar, int target){
        int i=0;
        int j = ar.length-1;
        while(i<j){
            if(ar[i]+ar[j] < target){
                i++;
            }else if(ar[i]+ar[j]>target){
                j--;
            }else{
                return new int[]{i,j};
            }
        }
        return new int[2];
    }


    public static int[] tsumsHashmap(int[] ar,int target){
       HashMap<Integer,Integer> map =  new HashMap<Integer,Integer>();
        for(int i=0;i<ar.length;i++){
            if(map.containsKey(target-ar[i])){
                return new int[]{map.get(target-ar[i]),i};
            }
            map.put(ar[i],i);
        }
        return new int[2];
    }


}
