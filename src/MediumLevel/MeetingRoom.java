package MediumLevel;

import java.util.Arrays;

public class MeetingRoom {

    public static void main(String[] args) {
        canAttendAllMeeting(new int[][]{
                {0,30},{5,10},{15,20}
        });
    }

    // sort the array based on start point so that array will be in ascending order and it is for sure that we have to compare only first  and second array so no need to compare each and every meeting with each other
    // and then compare end point of first meeting with start point of next meeting as if endpoint of first meeting is greater than start of next meeting then it will overlap
    // ex. meeting1= (1,30), meeting2= (5,10) = overlap situation as end of first meeting is 30 which is greater than start of next meeting which is 5

    public static boolean canAttendAllMeeting(int[][] intervals){
        Arrays.sort(intervals, (start, end)-> Integer.compare(start[0],end[0]));
        for(int i= 0;i<intervals.length-1;i++){
            int[] meeting1 = intervals[i];
            int[] meeting2 = intervals[i+1];
            if(meeting1[1]> meeting2[0]){
                return false;
            }
        }
        return false;
    }
}
