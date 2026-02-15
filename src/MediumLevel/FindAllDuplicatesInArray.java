package MediumLevel;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    public static void main(String[] args) {

    }

    public List<Integer> findAllDuplicatesOnSpace(int[]ar){
        List<Integer> duplicatesList = new ArrayList<>();
        for(int i=0;i<ar.length;i++){
            int index = Math.abs(ar[i]-1);
            if(ar[index]<0){
                duplicatesList.add(Math.abs(index)+1);
            }
            ar[index]= -ar[index];
        }
        return duplicatesList;
    }
}
