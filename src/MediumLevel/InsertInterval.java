package MediumLevel;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] res = insertInterval(new int[][]{ {1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8});
    }

    public static int[][] insertInterval(int[][] intervals,int [] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                res.add(in);
            } else if (in[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = in;
            } else {
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(newInterval[1], in[1]);
            }
        }
        res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}
