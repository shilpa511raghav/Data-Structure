public class SingeNumberFind {

    public static void main(String[] args) {
        int res = singleNumber(new int[]{4,1,2,1,2});
        System.out.println("res==== "+res);
    }


    //XOR bit manipulaion not clear yet for me
    public static int singleNumber(int[] arr) {
        int result =0;
        for(int i : arr){
            result = result ^ i;
        }
        return result;
    }
}
