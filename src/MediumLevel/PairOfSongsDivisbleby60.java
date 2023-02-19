package MediumLevel;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongsDivisbleby60 {
    public static void main(String[] args) {
        int count = pairOfSongDivisibleBy60BruteForce(new int[]{30, 20, 150, 100, 40});
        int count2 = pairOfSongDivisibleBy60BruteForce(new int[]{60, 60, 60});
        int count3 = pairOfSongsDivibleBy60Optimal(new int[]{30, 60,20,40, 60,150,120});
        System.out.println(count3);
    }

    //find all combination of i j and get which pair is divisible by 60, count that
    public static int pairOfSongDivisibleBy60BruteForce(int[] ar) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                int pair = ar[i] + ar[j];
                if (pair % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    //if remainder of both the pairs is divisible by 60 then both pairs will be divisible by 60
    // if one value is = 20 and other will be  as 60-20 i.e(40) then that pair will be divisible by 60
    // iterate and check remainder of each and also find target to find other value
    // and searchCriteria for collecting count will be different for 0 remainder and for other remainders values
    public static int pairOfSongsDivibleBy60Optimal(int[] ar) {
        Map<Integer, Integer> map = new HashMap();
        int countPair = 0;
        for (int t : ar) {
            int remainder = t % 60;
            int target = 60 - remainder;

                if (remainder == 0) {
                    countPair += map.getOrDefault(0, 0); // if  remainder 0 present then return that value otherwise return default value;
                }else {
                    countPair += map.getOrDefault(target, 0);
                }
                //Add or update the value: if remainder present then update by 1 otherwise add remainder with freq 1;
                //map.put(remainder,map.getOrDefault(remainder,0)+1); // this single line can replace below add and update code
                if(map.containsKey(remainder)){
                    map.put(remainder,map.get(remainder)+1);
                }else{
                    map.put(remainder,1);
                }
            }

        return countPair;
    }
}
