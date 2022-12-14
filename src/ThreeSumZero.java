import java.util.*;

public class ThreeSumZero {
    public static void main(String[] args) {
        System.out.println(threeSumO(new int []{-1,0,1,2,-1,-4}));
        System.out.println(threeSumOptimal(new int[]{-1,0,1,2,-1,-4}));
    }

    //Brute Force
    public static List<Integer> threeSum(int[] ar) {
        Arrays.sort(ar);
        Set<List<Integer>> uniqueSet = new HashSet();
        for (int i = 0; i < ar.length -2; i++) {
            for (int j = i + 1; j < ar.length-1; j++) {
                for (int k = j + 1; k < ar.length; k++) {
                    if (ar[i] + ar[j] + ar[k] == 0) {
                            uniqueSet.add(Arrays.asList(ar[i], ar[j], ar[k]));
                    }
                }
            }
        }
        return new ArrayList(uniqueSet);
    }


    //Optimal Algorithm with On^2 - Time complexity
    public static List<Integer> threeSumOptimal(int[] ar){
        if(ar.length<3) return new ArrayList<>();
        Arrays.sort(ar); // nlogN
        Set <List<Integer>> set = new HashSet<>();
        for(int i=0;i<ar.length-2;i++){
            int j=i+1;
            int k=ar.length-1;
            while (j<k){
                int sum = ar[i]+ar[j]+ar[k];
                if(sum == 0){
                    set.add(Arrays.asList(ar[i],ar[j],ar[k]));
                    j++;
                    k--;
                }else if(sum >0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList(set);
    }

    public static List<List<Integer>> threeSumO(int[] ar){
        if(ar.length<3) return new ArrayList();
        Arrays.sort(ar);
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0;i<ar.length-2;i++){
            int j = i+1;
            int k = ar.length-1;
            while(j<k){
                int sum = ar[i]+ar[j]+ar[k];
                if(sum== 0){
                    set.add(Arrays.asList(ar[i],ar[j++],ar[k--]));
                }else if(sum>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList(set);
    }
}
