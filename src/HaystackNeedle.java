public class HaystackNeedle {

    public static void main(String[] args) {
        int indexing = firstOccurenceOfIndexHaystack("abcabdaabcabcd","abcd");
        //int indexing = indexOfsubStringInString("hello","ll");
        System.out.println("indexing "+indexing);
    }

    public static int firstOccurenceOfIndexHaystack(String haystack, String needle){
        if(haystack == null || needle == null || needle.length()>haystack.length()) return -1;
        if(needle.length() == 0) return 0;

        return haystack.indexOf(needle);
    }

    /*public static int indexOfsubStringInString(String haystack,String needle){
        if(haystack == null || needle== null || needle.length()>haystack.length()) return -1;
        if(needle.length() == 0 ) return 0;
        int i=0;
        for(;i<haystack.length()-needle.length();i++){
            for(int j=0;j<needle.length();j++){
              if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }
    }*/
}
