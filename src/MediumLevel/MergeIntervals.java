package MediumLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] output = mergeIntervals(new int[][]{{22, 28}, {1, 8}, {25, 27}, {17, 19}, {27, 30}, {5, 12}});
        System.out.println(Arrays.deepToString(output));

    }

    // create empty list of integer array as response array
    //first sort the 2D array
    // then take first array from intervals in separate array and then loop from 2nd array i.e i=1 and compare separate arrays second element with first element of i array in loop
    //if separate array second element < first element of i array in loop  then add this separate array to response array and replace separate array with i array in loop and so on
    //else find max from second element of separate array and second element from i array and replace this max value to the second element of seperate array and so on
    //edge case if loop completed and element in separate array has been present and not being added  then add that element also in separate array
    public static int[][] mergeIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList();
        if (intervals.length <= 1) {
            return intervals;
        }
        int[] in = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (in[1] < intervals[i][0]) {
                res.add(in);
                in = intervals[i];
            } else {
                in[1] = intervals[i][1] > in[1] ? intervals[i][1] : in[1]; // can use Math.max as well to find max between both
            }
        }
        res.add(in);
        return res.toArray(new int[res.size()][]);
    }
}
