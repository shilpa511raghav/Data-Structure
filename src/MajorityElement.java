import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {

        //int my =  majorityElementHashMap(new int[]{2,5,1,3,4,7});
        //int el = majorityElementHashMap(new int[]{1, 2, 1, 2, 3, 2,5,5,5});
        //int el = majorityElementHashMap(new int[]{1, 2, 1, 2, 3});
        int el = majorityElementHashMap(new int[]{1, 2, 3, 4, 5, 5, 5, 5}); // if majority element are strictly following more than n/2
        //int el = mooreMajorityElement(new int[]{3,2,3});
        System.out.println("el===  " + el);

    }
    //Given an array nums of size n, return the majority element.
    //The majority element is the element that appears more than n / 2 times. You may assume that the majority element always exists in the array.

/*
    *Constraints:

            n == nums.length
            1 <= n <= 5 * 104
            -231 <= nums[i] <= 231 - 1
     *//*


     */
/*
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2

    */

    //time Complexity O(n^2) and space O(1)
    public static int majorityElementsInArray(int[] nums) {
        int majorityElement = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count += 1;
                }

                if (count > majorityElement) {
                    return nums[i];
                }
            }
        }
        return -1;
    }


    public static int majorityElementInArray(int[] ar) {
        if (ar.length == 1) {
            return ar[0];
        }
        Arrays.sort(ar);

        int i = 0;
        int j = 0;
        int count = 0;
        int majorityCount = ar.length / 2;
        while (j < ar.length) {
            if (ar[i] == ar[j]) {
                count += 1;
            }
            i++;
            j++;
            if (count >= majorityCount) {
                return ar[i];
            }

        }
        return -1;
    }


    public static int majorityElementHashMap(int[] ar) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int each : ar) {
            if (countMap.containsKey(each)) {
                countMap.put(each, countMap.get(each) + 1);
            } else {
                countMap.put(each, 1);
            }
        }


        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }


    public static int majorityEl(int[] ar) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (!countMap.containsKey(ar[i])) {
                countMap.put(ar[i], 1);
            } else {
                countMap.put(ar[i], countMap.get(ar[i] + 1));
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }

        }
        return majorityEntry.getKey();
    }

    //if majority elements strictly following n/2 i.e if array has 10 elements then surely majority element should be present 6 timmes
    public static int me(int[] ar) {
        Arrays.sort(ar);
        int mel = ar[ar.length / 2];
        return mel;
    }


    //Moore's voting algorithm
    public static int mooreMajorityElement(int ar[]) {
        int val = ar[0];
        int count = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == val) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                val = ar[i];
                count = 1;
            }
        }
        int actualCount = 0;
        for (int j = 0; j < ar.length; j++) {
            if (ar[j] == val) {
                actualCount++;
            }
        }
        if (actualCount > ar.length / 2) {
            return val;
        }
        return 0;
    }


    public static int majoEleem(int[] ar) {
        int count = 0;
        Integer candidate = null;

        for (int each : ar) {
            if (count == 0) {
                candidate = each;
                count = count + ((each == candidate) ? 1 : -1);
            }
        }
        return candidate;
    }


    public static int majEl(int[] ar) {
        int count = 0;
        int maj = 0;

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i] == ar[j]) {
                    count++;
                }
                if (count > ar.length / 2) {
                    maj = ar[i];
                }
            }
        }
        return maj;
    }


    public static int melo(int[] ar) {
        Map<Integer, Integer> countmap = new HashMap<Integer, Integer>();
        for (int each : ar) {
            if (countmap.containsKey(each)) {
                countmap.put(each, countmap.get(each) + 1);
            } else {
                countmap.put(each, 1);
            }
        }
        Map.Entry<Integer, Integer> maje = null;
        for (Map.Entry<Integer, Integer> eachentry : countmap.entrySet()) {
            if (maje == null || eachentry.getValue() == maje.getValue()) {
                maje = eachentry;
            }
        }
        return maje.getKey();
    }


    public static int mte(int ar[]) {
        int candidate = ar[0];
        int count = 1;

        for (int i = 1; i < ar.length; i++) {
            if (candidate == ar[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = ar[i];
            }
        }

        int ac = 0;
        for (int each : ar) {
            if (each == candidate) {
                ac++;
            }
        }
        if (ac > ar.length / 2) {
            return candidate;
        }
        return -1;
    }


    public static int majoEl(int ar[]) {
        int candidate = 0;
        int count = 0;

        for (int each : ar) {

            if (count == 0) {
                candidate = each;
            }
            count += candidate == each ? +1 : -1;
        }

        return candidate;
    }


}

