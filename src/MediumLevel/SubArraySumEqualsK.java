package MediumLevel;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int res = subArSumEqualK(new int []{3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1},5);
        int res2 = subArSumEqualK(new int []{1,1,1},2);
        int res3 = subArSumEqualK(new int []{3,2,5},5);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
    }
    //Accumulate sum each time
    // and calculate difference between accSum and given sum  k  each time
    // and search this difference in frequency map- if present in map then increase count by getting frequency fro map
    // and along with it each time add or update in map as well (i.e add new accSum with freq 1 or if same accSum present in map then increase by 1)  (getOrDefault method of map)
    public static int subArSumEqualK(int ar[], int k){
       Map<Integer, Integer> freqMap= new HashMap<>();
       freqMap.put(0,1);
       int accSum=0;
       int rSum=0;
       int countSubAr = 0;
       for(int i=0;i<ar.length;i++){
           accSum+= ar[i];
           rSum = accSum-k;
           if(freqMap.containsKey(rSum)){
               countSubAr+= freqMap.get(rSum);
           }
           freqMap.put(accSum,freqMap.getOrDefault(accSum,0)+1); // here increase accSum with freq as 1 which is +1 and if not found then add new accsum with sum as deafult(0)+1 wwhich is 1 only
       }
       return countSubAr;
    }
}
