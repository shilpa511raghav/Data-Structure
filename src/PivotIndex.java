public class PivotIndex {
    public static void main(String[] args) {
        int pivotIndex = findPivotIndex(new int[]{1,7,3,6,5,6}); // pivot index will be 6
        System.out.println(pivotIndex);
    }

    //find total sum first
    //take leftSum=0 initially as pivot index can be 0th index as well
    // now rightSum = totalSum -currentIndex-LeftSum
    //if leftSum== RightSum return index
    //add current index value in leftSum in every iteration untill found leftMost pivot index;

    public static int findPivotIndex(int[]ar){
        int total= 0;
        for(int i=0;i<ar.length;i++){
            total+=ar[i];
        }
        int leftSum=0;
        for(int j=0;j<ar.length;j++){
            int rightSum= total-ar[j]-leftSum;
            if(leftSum==rightSum){
                return j;
            }
            leftSum+=ar[j];
        }
        return -1;
    }
}
