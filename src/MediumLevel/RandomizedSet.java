package MediumLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {

    public static void main(String[] args) {

    }

    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet(){
        map  = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val){
        if(!map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;

    }
    public boolean remove(int val){
        if(!map.containsKey(val)) return false;
        
    }
}
