public class MaxSumSubArraySlidingWindow {

    public static void main(String[] args) {
        int output = slidingWindowMaxSumSubArray(new int[]{2, -1, 12, -1, -4, 2, 5}, 3);
        System.out.println("max sum = " + output);
    }

    public static int slidingWindowMaxSumSubArray(int[] ar, int windowSize) {

        int i = 0;
        int j = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (j < ar.length) {
            sum += ar[j];
            if (j - i + 1 < windowSize) {
                j++;
            } else if (j - i + 1 == windowSize) {
                maxSum = maxSum > sum ? maxSum : sum;
                sum -= ar[i];  // here first we have to subtract i then increment only below otherwise wrong index number will be minus
                i++;
                j++;
            }
        }
        return maxSum;
    }


    //key points
    // window start and end points
    // now we can move window upto when j<ar.legth i.e j reached at lst then we will not move window
    // first hit windows size and do calculations everytime
    // when windows size hit then move window

    public static int maxsmSbArr(int[] ar, int ws){
        int i=0;
        int j=0;
        int sum =0;
        int maxSum = Integer.MIN_VALUE;
        while(j<ar.length){
            sum+= ar[j];
            if(j-i+1<ws){
                j++;
            }else if(j-i+1 == ws){
                maxSum = maxSum > sum?maxSum:sum;
                sum-=ar[i];
                i++;
                j++;
            }
        }
        return maxSum;


    }




}
