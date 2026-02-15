package MediumLevel;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumberFloydCycleDetection {
    public static void main(String[] args) {
       int output =  findDuplicateOptimalWithoutExtraSpaceAndTime(new int[]{1,3,4,2,2});
       int output2 =  findDuplicateOptimalWithoutExtraSpaceAndTime(new int[]{3,1,3,4,2});
        System.out.println(output);
        System.out.println(output2);
    }

    //Extra space
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    //Floyd cycle detection algorithm usage : constant space and time
    //array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    public static int findDuplicateOptimalWithoutExtraSpaceAndTime(int[] nums){
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
            fast = nums[0];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
    }
    
}
