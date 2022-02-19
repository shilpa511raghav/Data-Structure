import java.util.Arrays;

public class LongestCommonPrefixInString {

    public static void main(String[] args) {

        System.out.println(longestComnPrefix(new String[]{"fle", "flower", "flow", "oflofl", "floght"}));
        System.out.println(longestComnPrefix(new String[]{"flow","flower","flow","flown","flone"}));
        System.out.println(longestComnPrefix(new String[]{"flew","flower","flow","","floght"}));
        System.out.println(longestComnPrefix(new String[]{"flew","flower","flow","fl","floght"}));
    }

    //Way to find min length In a string array
    public static int shortestString(String[] ar) {
        int min = ar[0].length();
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].length() < min) {
                min = ar[i].length();
            }
        }
        return min;
    }

    /*public static String longestCommonPrefixString(String[] strs) {

        int j=0;
        String first = strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            if(first.charAt(j)== strs[i].charAt(j)) {
                sb.append(first.charAt(j));
            }else{
                return new StringBuilder().toString();
            }
            j++;
        }
        return sb.toString();
    }*/


    public static String longestComnPrefix(String[] strs) {
        //sorting way java 8
        /*String[] strArray = Stream.of(strs)
                .sorted()
                .toArray(String[]::new);*/
        Arrays.sort(strs);
        String cmnPrefix = "";
        int minLength = Math.min(strs[0].length(), strs[strs.length - 1].length());
        for (int i = 0; i < minLength; i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)){
                break;
            }
            cmnPrefix = cmnPrefix + strs[0].charAt(i);
        }
        return cmnPrefix;
    }

    //APPROACH 2 from internet complexity O(n)
   /* public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        System.out.println("pre---  "+pre);
        int i = 1;
        while(i < strs.length){
            System.out.println("strs[i]---"+strs[i]);
            System.out.println(strs[i].indexOf(pre));
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            System.out.println(i+","+ pre);
            i++;
        }
        return pre;
    }*/


    /*static String longestCmnPrefix(String[] strsAr){
        Arrays.sort(strsAr);
        int first = strsAr[0].length();
        int last = strsAr[(strsAr.length -1)].length();
        String cmnPre = "";
        int minLength = first < last ? first:last;
        for(int i=0;i<minLength;i++){
            if(strsAr[i].charAt(i) != strsAr[(strsAr.length-1)].charAt(i)){
                break;
            }

            cmnPre = cmnPre + strsAr[i].charAt(i);

        }
        return cmnPre;
    }*/
}
