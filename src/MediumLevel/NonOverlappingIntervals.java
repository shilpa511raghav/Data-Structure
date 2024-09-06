package MediumLevel;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int noOfIntervalsRemoved = minIntervalsToRemoveToMakeNonOverLappingIntervals(new int [][]{
                {1,2},{2,3},{3,4},{1,3}
        });

        /*int noOfIntervalsRemoved = minIntervalsToRemoveToMakeNonOverLappingIntervals(new int [][]{
                {1,2},{1,2},{1,2}
        });*/
    }
    //first sort the elements for better comparison and removal as without sorting we are not able to easily identify which are overlapping which are not and with whom
    // we have to keep track of prevEnd, so initially we have to keep end of first element in prevEnd and compare end of this element with start of next element
    // if end greater than start of next element then it's overlapping so need to remove one of the element so count it and then keep the element which is having minimum end value
    // why we are keeping only min end value which has minimum value because there is less possibility that the object which has minimum value will overlap with next coming elements
    public static int minIntervalsToRemoveToMakeNonOverLappingIntervals(int [][] intervals){
        int prevEnd = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]< prevEnd){
                count++;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
