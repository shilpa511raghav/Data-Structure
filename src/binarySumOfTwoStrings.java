public class binarySumOfTwoStrings {

    public static void main(String[] args) {
        //String s = binarySumString("001","110");
        String s = binrySumOftwoBinaryNums("1001", "1101");
        System.out.println("sum === atlast " + s);
    }

    static String binarySm(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum > 1 ? 1 : 0;
            result.append(sum % 2);
        }
        if (carry != 0) {
            result.append(carry);
        }
        result.reverse();
        return result.toString();
    }

    static String binrySumOftwoBinaryNums(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum = sum + a.charAt(i--) - '0';
                System.out.println(" first num each" + sum);
            }
            if (j >= 0) {
                sum = sum + b.charAt(j--) - '0';
                System.out.println("second num +first num " + sum);
            }
            carry = sum / 2;
            result.append(sum % 2);
        }
        if (carry != 0) {
            result.append(carry);
        }
        result.reverse();
        return result.toString();
    }


    //Day feb 2
    /*public static String addbinry(String a, String b) {
        int al = a.length() - 1;
        int bl = b.length() - 1;
        StringBuilder bSum = new StringBuilder();

        int carry = 0;
        int sum;

        while (al >= 0)||bl >= 0){
           sum = carry;
            if(al >=0){
                sum = sum+a.charAt(al)-'0';
            }
            if(bl>=0){
                sum = sum+b.charAt(bl)-'0';
            }

            bSum.append(sum%2);
            carry = sum/2;

            if(carry!=0){
                bSum.append(carry);
            }
            bSum.reverse();
            return bSum.toString();
        }
    }*/

    /*static String binarySumString(String a,String b){

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum =   sum+b.charAt(j) - '0' ;
            }
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
            j--;
            i--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }*/

    //My Approach
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();


        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += Integer.parseInt(String.valueOf(s1[i--]));
            }
            if (j >= 0) {
                sum += Integer.parseInt(String.valueOf(s2[j--]));
            }
            //carry occurs when sum of math digits is 2 and 3 i.e >1
            carry = sum > 1 ? 1 : 0;
            //binary Sum = 1 is for only odd digits sums number i.e 1 and 3

            //  binary numbers  mathdigitsumofbinarynums  binary sum   binary carry
            //  0+0                (0+0)=  1                    = 0        0
            //  0+1                (0+1)=  1                    = 1        0
            //  1+0                (1+0)=  1                    = 1        0
            //  1+1                (1+1)=  2                    = 0        1
            //  1+1+(carry)1      (1+1+1)= 3                    = 1        1
            sum = sum % 2 == 0 ? 0 : 1;
            result.append(sum);
        }

        if (carry != 0) {
            result.append(carry);
        }

        result.reverse();
        return result.toString();
    }



    public static  String bnsum(String bn1,String bn2){
        StringBuilder result = new StringBuilder();
        int carry =0;
        int bn1l = bn1.length()-1;
        int bn2l = bn2.length()-1;

        while(bn1l >=0 || bn2l >=0){
            int sum = carry;
            if(bn1l>=0){
                sum = sum+ bn1.charAt(bn1l--)-'0';
            }

            if(bn2l>=0){
                sum = sum+bn2.charAt(bn2l--)-'0';
            }

            result.append(sum%2);
            carry = carry/2;

            if(carry != 0){
                result.append(carry);
            }
        }
        result.reverse();
        return result.toString();
    }
}
