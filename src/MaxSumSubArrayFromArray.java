public class MaxSumSubArrayFromArray {

    public static void main(String[] args) {
        //int maxSum = maxSumSubArrayOptimal(new int[]{5,4,-1,7,8}); // 23
        //int maxSum = maxSumSubArrayOptimal(new int[]{-1});
        //int maxSum = maxSumSubArrayOptimal(new int[]{-2,1,-3,4,-1,2,1,-5,4}); // 6
        int maxSum = maxSumSubArrayOptimal(new int[]{-1, -2}); // 6
        //int maxSum = maxSumSubArrayOptimal(new int[]{1});
        System.out.println("max sum == " + maxSum);

    }

    //BRUTE FORCE with O(n^3) complexity
    public static int maxSumSubArray(int[] ar) {
        int res = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += ar[k];
                }
                res = res >= sum ? res : sum;
            }
        }
        return res;
    }

    //BruteForce 2 loops O(n^2) complexity
    public static int bruteForce2loops(int[] ar) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            int sum = 0;
            for (int j = i; j < ar.length; j++) {
                sum += sum + ar[j];
                maxSum = maxSum > sum ? maxSum : sum;
            }

        }
        return maxSum;
    }

    //BRUTE FORCE with two loops only O(n^2) complexity
    public static int maxSumSubArrayAApproach2(int[] ar) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {

            int sum = 0;
            for (int j = 0; j < ar.length; j++) {
                if (i != j) {
                    sum += ar[j];
                    res = res >= sum ? res : sum;
                } else {
                    sum = ar[i];
                    res = res >= sum ? res : sum;
                }
            }

            /*for(int j=i ;j<i;j++){
                sum+= ar[j];
                res = res >=sum ? res:sum;
            }*/
        }
        return res;
    }

    //O(n) sliding window approach- Dont add with  negative prefix but we can add with negative suffix as there is chance of coming positive going forward
    public static int maxSumSubArrayOptimal(int[] ar) {
        int curSum = ar[0];
        int maxSum = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (curSum < 0) {
                curSum = ar[i];
            } else {
                curSum += ar[i];
            }

            maxSum = curSum > maxSum ? curSum : maxSum;
        }

            /*for(int i=1;i<ar.length;i++){
                if(curSum>0){
                    curSum+= ar[i];
                }else{
                    curSum = ar[i];
                }
               if(curSum>maxSum){
                   maxSum = curSum;
               }
            }*/

        return maxSum;
    }

    public static int bruteForce3loops(int[] ar) {
        int maxSum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                int curSum = 0;
                for (int k = i; k <= j; k++) {
                    curSum += ar[k];

                }
                maxSum = curSum > maxSum ? curSum : maxSum;
            }
        }
        return maxSum;
    }



    //Optimal Approach O(n) complexity
    public static int kadaneMaxSumSubArray(int[] ar) {
        int curSum = ar[0];
        int maxSum = ar[0];

        for (int i = 0; i < ar.length; i++) {
            if (curSum < 0) {
                curSum = ar[i];
            } else {
                curSum += ar[i];
            }
            maxSum = curSum > maxSum ? curSum : maxSum;
        }
        return maxSum;
    }


    //Date 1 feb
    public static int maxSm(int[]ar){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<=ar.length;i++){

            for(int j=i;j<ar.length;j++){
                int curSum=0;
                for(int k=i ;k<=j;k++){
                    curSum+= ar[k];
                }
                maxSum = maxSum>curSum?maxSum:curSum;
            }
        }
        return maxSum;
    }


    public static  int maxSmSBAr(int[] ar){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++){
            int sum = 0;
            for(int j=i;j<ar.length;j++){
                sum = sum+ar[j];
                maxSum = maxSum > sum ? maxSum:sum;
            }

        }
        return maxSum;
    }



    public static int mxSumSub(int[] ar){
        int curSum = ar[0];
        int maxSum = ar[0];

        for(int i=1;i<ar.length;i++){
            if(curSum<0){
                curSum = ar[i];
            }else{
                curSum+=ar[i];
            }

            maxSum = maxSum >curSum ? maxSum:curSum;
        }
        return maxSum;
    }



}
