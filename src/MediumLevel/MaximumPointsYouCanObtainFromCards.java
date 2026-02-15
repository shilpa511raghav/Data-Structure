package MediumLevel;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
       int output =  maxPointsCanObtainFromCardsSlidingWindow(new int[]{1,2,3,4,5,6,1},3);
        System.out.println(output);
    }

    //Steps: Sliding Window Approach: As we have to take either first element or either last element of array in order to calculate total

    // find total from start till length equal to k using loop
    // After finding total start index from k-1 index in a loop and then remove last index value from total and add kth index value act as sliding window
    public static int maxPointsCanObtainFromCardsSlidingWindow(int ar[],int k){
        int total = 0;
        for(int i=0;i<k;i++){
            total+=ar[i];
        }
        System.out.println("total"+total);
        int bestMaxPoints = total;
        System.out.println("best"+bestMaxPoints);
        for(int i=k-1,j=ar.length-1;i>=0;i--,j--){
            total= total+ar[j]-ar[i];
            bestMaxPoints = (total>bestMaxPoints)?total:bestMaxPoints;
        }
        return bestMaxPoints;
    }
}
