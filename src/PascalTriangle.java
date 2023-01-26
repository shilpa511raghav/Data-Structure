import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    //Steps: store prevRow and use it for next row calculation and accumulate each row in output for result
    //pascal traingle : elements in a row is equal to row only and first and last element of each row is 1 always and other middle elements are sum of prev and next of each index
    public static void main(String[] args) {
        List<List<Integer>> res = pascalTriangle(7);
        System.out.println(res);
    }

    public static List<List<Integer>> pascalTriangle(int rows){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> pre = null;
        for(int i=0;i< rows;i++){
            List<Integer> eachRow = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    eachRow.add(1);
                }else{
                    eachRow.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = eachRow;
            output.add(eachRow);

        }
        return output;
    }
}
