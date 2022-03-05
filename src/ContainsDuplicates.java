import java.util.HashSet;

public class ContainsDuplicates {

    public static void main(String[] args) {
        
    }
    //using hash set O(n) time and space O(n)
    public static boolean containDuplicates(int[] ar){
        HashSet<Integer> set = new HashSet<>();

        for(int each: ar){
            if(set.contains(each)){
                return true;
            }else{
                set.add(each);
            }
        }
        return false;
    }

    //approach 2 using hash map-- add all numbers in hashmap and then count if any present count == 2  return true
}
