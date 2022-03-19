import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        //validAnagramApproachSecond("abtzab", "abtzab");
        System.out.println(isAnagram("abtzab", "abtzab"));
    }

    //Approach 1 using HashMap
    public static boolean findValidAnagram(String s, String x) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        if (s.length() != x.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int j = 0; j < x.length(); j++) {
            char c = x.charAt(j);
            if (!map.containsKey(c)) {
                return false;
            } else if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        return map.size() == 0;
    }

    //ASCII code usage as ASCII of small a = 97 and when we use -'a' then ascii is subtracted for both instead of integers
    public static boolean validAnagramApproachSecond(String s, String t) {
        int[] alphabetCount = new int[26];
        if (s.length() != t.length()) return false;
                        /*for (int i = 0; i < s.length(); i++) {
                            alphabetCount[s.charAt(i)-'a']= alphabetCount[s.charAt(i)-'a'] +1;
                        }
                        for(int j=0;j<t.length();j++){
                            alphabetCount[t.charAt(j)-'a'] = alphabetCount[s.charAt(j)-'a']-1;
                        }*/


        //check simultaneously in both strings one by one character if length is same as length we have checked allready above so it will be same only then will come to this loop
        for (int i = 0; i < s.length(); i++) {
            //add in alphabtical position for first index of first string
            alphabetCount[s.charAt(i) - 'a'] = alphabetCount[s.charAt(i) - 'a'] + 1;
            //subtract from alphabetical position for first index character of second string
            alphabetCount[t.charAt(i) - 'a'] = alphabetCount[t.charAt(i) - 'a'] - 1;
            //so after these two statement execution for a particular index if for example a is present in both string's same index then add and subtract will make it again 0 at that particular position , nothing is added
        }

        for(int each: alphabetCount){
            if(each != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t){
        int counts[] = new int[26];
        if(s.length()!=t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            counts[s.charAt(i) - 'a']+=1;
            counts[t.charAt(i) - 'a']-=1;

        }
        for(int each: counts){
            if(each != 0){
                return false;
            }
        }

        return true;
    }
}


