package MediumLevel;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int res= containerWithMostWaterOptimal(new int[]{1,8,6,2,5,4,8,3,7});
        int res2= containerWithMostWaterOptimal(new int[]{1,1});
        System.out.println(res);
        System.out.println(res2);
    }
    //BruteForce: Use two loop and find all pairs and also calculate height and width  and compare with max
    public static int containerWithMostWaterBruteForce(int[]ar){
        int maxWaterCapacity = 0;
        if(ar.length == 2){
            return Math.min(ar[0],ar[1]);
        }
        for(int i=0;i<ar.length-2;i++){
            for(int j=i+1;j<ar.length;j++){
                int height = Math.min(ar[i],ar[j]); //max height of water depends upon lower value
                int width = Math.abs(i-j); //
                int water = height * width;
                maxWaterCapacity = water > maxWaterCapacity ? water:maxWaterCapacity;
            }
        }
        return maxWaterCapacity;
    }
    // Take two pointer left and right and move pointer which is smaller as there is possibility of getting higher value to make a big container if we found higher value next to minimum value.
    //calculate height which is minimum as we cannot fill water more than a min height out of two heights from left and right
    // width is calculated by difference between indices
    //find maxWater(area in coding) and if find another maxWater then update maxWater
    public static int containerWithMostWaterOptimal(int[]ar){
        int maxWater = 0;
        int i=0;
        int j= ar.length-1;
        while(i<j){
            int width = Math.abs(i-j);
            int height = Math.min(ar[i],ar[j]);
            maxWater = maxWater > width*height ?maxWater :width*height;
            if(ar[i]<=ar[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }
}
