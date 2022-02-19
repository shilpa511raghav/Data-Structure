public class SearchInsertPosition {
    public static void main(String[] args) {
        //int output = searchPosition(new int[]{1, 3, 5, 7}, 8);
        /*int output1 = searchInsertPositionBinarySearch(new int[]{1, 3, 5, 7}, 5);
        int output2 = searchInsertPositionBinarySearch(new int[]{1, 3, 5, 7}, 8);
        int output3 = searchInsertPositionBinarySearch(new int[]{1, 3, 5, 7}, 0);*/
        int output3 = searchInsertPositionBinarySearch(new int[]{1, 5, 7, 9}, 5);
        /*System.out.println("output1 ===" + output1);
        System.out.println("output2 ===" + output2);*/
        System.out.println("output3 ===" + output3);
    }

    //BRUTE FORCE with O(n) complexity
    public static int searchPosition(int[] ar, int searchNum) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == searchNum) {
                return i;
            } else if (ar[i] > searchNum) {
                return i;
            }
        }
        return searchNum;
    }

    //Binary Search with O(nlogn) complexity
    public static int searchInsertPositionBinarySearch(int[] ar, int num) {
        int low = 0;
        int high = ar.length - 1;
        int mid = 0;

        while (low <= high) {
            //mid = low + ((high - low) / 2);
            mid = (high + low) / 2;
            if (ar[mid] < num) {
                low = mid + 1;
            } else if (ar[mid] > num) {
                high = mid - 1;
            } else {
                return mid;
            }

        }
        return low;
    }


    public static int binarySearch(int[] ar, int searchNum) {
        int lowIndex = 0;
        int highIndex = ar.length - 1;
        int middleIndex;

        while (lowIndex <= highIndex) {
            middleIndex = (lowIndex + highIndex) / 2;
            if (ar[middleIndex] < searchNum) {
                lowIndex = middleIndex + 1;
            } else if (ar[middleIndex] > searchNum) {
                lowIndex = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return lowIndex;

    }


    public static int searchInsertPosition(int[] sortedAr, int num) {
        for (int i = 0; i < sortedAr.length; i++) {
            if (sortedAr[i] == num) {
                return i;
            } else if (sortedAr[i] > num) {
                return i;
            }
        }
        return num;
    }


    //DAy feb 1 2022
    public static int bs(int ar[],int n){
        int l = 0;
        int h = ar.length-1;
        int m;

        while(l<=h){
            m = (l+h)/2;
            if(ar[m]< n){
                l= m+1;
            }else if(ar[m]> n){
                h = m-1;
            }else{
                return m;
            }
        }
        return l;
    }
}

