public class ClimbingStairs {
    public static void main(String[] args) {
        int c= climb(5);
        System.out.println("ways=== "+c);
    }

    //Dynamic programming
    public static int climbingStr(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Fibonacci way for climb stairs
    public static int climbingStrSpace(int n) {
        if (n == 1) {
            return 1;
        }
        int oneStep = 1;
        int twoStep = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = twoStep;
            twoStep = oneStep + twoStep;
            oneStep = tmp;
        }
        return twoStep;
    }


    public static int climb(int n){
        if(n==1){
            return 1;
        }
        int oneStep = 1;
        int twoStep = 1;

        for(int i=2;i<n;i++){
            int temp = twoStep;
            twoStep += oneStep;
            oneStep = temp;
        }
        return twoStep;
    }

}
