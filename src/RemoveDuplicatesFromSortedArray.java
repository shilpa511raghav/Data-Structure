public class RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {

        int count = removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println("count====" + count);
    }

    public static int removeDuplicates(int[] ar) {
        if (ar.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < ar.length; j++) {
            if (ar[i] != ar[j]) {
                i++;
                ar[i] = ar[j];
            }
        }
        return i + 1;

    }
}
