package MediumLevel;

import java.util.*;

//Map the values with index of arrayList and store key as actual number in hashmap
public class InsertRemoveGetRandomO1 {

    public static void main(String[] args) {
        InsertRemoveGetRandomO1 dataStructure = new InsertRemoveGetRandomO1();
        dataStructure.insert(10);
        dataStructure.insert(20);
        dataStructure.insert(30);
        dataStructure.remove(30);
        dataStructure.insert(40);
        dataStructure.getRandom();
        dataStructure.remove(20);
        dataStructure.remove(50);
        dataStructure.getRandom();
    }

    Map<Integer, Integer> map;
    List<Integer> list;
    Random r;
    public InsertRemoveGetRandomO1(){
        map  = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();

    }

    public boolean insert(int val){
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;

    }
    //edge case if element to remove is last element in arraylist then dont swap just remove from last index itself
    public boolean remove(int val){
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        map.remove(val);
        if(index == list.size()-1){
            list.remove(list.size()-1);
            return true;
        }
        int swappedIn = list.get(list.size()-1);
        list.set(index,swappedIn);
        map.put(swappedIn,index );
        list.remove(list.size()-1);
        System.out.println( list);
        return true;

    }

    public int getRandom(){
            int randomIndex = r.nextInt(list.size());
            return list.get(randomIndex);
    }


}
