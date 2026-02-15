package MediumLevel;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {

    }

    public static List<Integer> fourSumBruteForce(int ar[], int target) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(ar);
        HashSet<List<Integer>> uniqueSet = new HashSet();
        for (int i = 0; i < ar.length - 3; i++) {
            for (int j = i + 1; j < ar.length - 2; j++) {
                for (int k = j + 1; k < ar.length - 1; k++) {
                    for (int l = k + 1; k < ar.length;l++) {
                        if ((ar[i] + ar[j] + ar[k] + ar[l]) == target) {
                            uniqueSet.add(Arrays.asList(ar[i], ar[j], ar[k], ar[l]));
                        }
                    }
                }
            }
        }
        return new ArrayList(uniqueSet);
    }

    public static List<List<Integer>> fourSumPointerTechnique(int ar[], int target) {
        Arrays.sort(ar);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < ar.length - 3; i++) {
            if (i > 0 && ar[i] == ar[i - 1]) { // if same element found next then skip that for i
                continue;
            }
            for (int j = i + 1; j < ar.length - 2; j++) {
                if (j > i + 1 && ar[j] == ar[j - 1]) {
                    continue;
                }
                int rsum = target - (ar[i] + ar[j]);
                int curSum = 0;
                int li = j + 1;
                int ri = ar.length - 1;
                while (li < ri) {
                    curSum = ar[li] + ar[ri];
                    if (curSum == rsum) {
                        set.add(Arrays.asList(ar[i], ar[j], ar[li], ar[ri]));
                    } else if (curSum < rsum) {
                        li++;
                    } else {
                        ri--;
                    }
                }
            }
        }
        return new ArrayList(set);
    }
}
