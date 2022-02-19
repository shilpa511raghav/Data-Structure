public class PalindromNumber {
    public static void main(String[] args) {
        /*System.out.println(palindrome(121));
        System.out.println(palindrome(-121));
        System.out.println(palindrome(1218));*/

        System.out.println("input1" + palindromeUsingTwoPointers(12222241));
        System.out.println("input1" + palindromeUsingTwoPointers(12234221));
        System.out.println("input2"+palindromeUsingTwoPointers(-121));
        System.out.println("input3" + palindromeUsingTwoPointers(1218));


    }

    public static boolean palindrome(int num) {
        int temp = num;
        int reversedNum = 0;

        while (num > 0) {
            int remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num = num / 10;
        }
        return (temp == reversedNum);
    }


    public static boolean palindromeUsingTwoPointers(int num) {
        if (num < 0) return false;
        int left = 0;
        String numStr = Integer.toString(num);
        int right = numStr.length() - 1;
        char[] arrayOfCh = numStr.toCharArray();
        while (left < right) {
            if (arrayOfCh[left] != arrayOfCh[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
