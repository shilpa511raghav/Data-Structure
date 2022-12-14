import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
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
