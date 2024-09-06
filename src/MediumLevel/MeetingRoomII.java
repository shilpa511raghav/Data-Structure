package MediumLevel;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public static void main(String[] args) {
        int noOfRoomsRequired = minMeetingRoomRequired(new int[][]{
                {1,3},{8,10},{9,15},{8,10},{7,8}
        });
        System.out.println(noOfRoomsRequired);
    }
    //sort the array based on start of the meeting so that meetings are in ascending order and easy for comparison of meetings
    // now we use Priority Queue as priority queue works in certain order either asc and desc and here we have arranged meetings in ascending order
    // now we have to compare end of first meeting with start of next meeting to check whether they are merging means meeting not over
    //so now here catch is we are not sure when any of the meeting over or any room vacant and with which meeting we have to compare end and start so for that we are using priority queue
    //in PQ we will store end point of meeting and as all meetings are in asc order so in pq when we will peek it gives which room vacant or meeting over
    // so we can compare now peek element of the queue with start of current meeting to verify whether meeting over or not
    // so finally we will observe that whatever the number of element stored in queue will give how many minimum meeting rooms required to accomodate all meetings
    public static int minMeetingRoomRequired(int[][] intervals){
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        Arrays.sort(intervals, (s,e)-> Integer.compare(s[0],e[0]));
        for(int[] interval : intervals){
            if(pq.size()==0){
                pq.add(interval[1]);
            }else{
                if(pq.peek()> interval[0]){
                    pq.add(interval[1]);
                }else{
                    pq.remove();
                    pq.add(interval[1]);
                }
            }
        }
        return pq.size();
    }
}
