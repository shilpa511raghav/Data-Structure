package MediumLevel;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosestBruteForce(new int[]{-1, 2, 1, 4}, 1));
        System.out.println(threeSumClosestBruteForce(new int[]{0, 0, 0}, 1));

    }

    //BruteForce
    public static int threeSumClosestBruteForce(int[] ar, int target) {
        int diff = Integer.MAX_VALUE;
        int closestSum = ar[0] + ar[1] + ar[ar.length - 1];
        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = i + 1; j < ar.length - 1; j++) {
                for (int k = j + 1; k < ar.length; k++) {
                    int curSum = ar[i] + ar[j] + ar[k];
                    int curDiff = Math.abs(target - curSum);
                    if (curDiff < diff) {
                        diff = curDiff;
                        closestSum = curSum;
                    }
                }
            }
        }
        return closestSum;
    }

    //Optimal using pointer technique:
    // find three sums and then  diff between curSm and target to get closest and
    // also compare the curDiff with previous diff and if curDiff is less than prevous diff then update  diff with curDiff and also update closest with curSum
    public static int threeSumClosestPointersTechnique(int ar[], int target) {
        Arrays.sort(ar);
        int diff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < ar.length - 2; i++) {
            int li = i + 1;
            int ri = ar.length - 1;
            while (li < ri) {
                int curSum = ar[i] + ar[li] + ar[ri];
                int curDiff = Math.abs(target - curSum);
                if (curSum < target) {
                    li++;
                } else {
                    ri--;
                }
                if (diff > curDiff) {
                    diff = curDiff;
                    closestSum = curSum;
                }
            }
        }
        return closestSum;
    }
}
