import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAllUniqueCharacters {
    public static void main(String[] args) {
        System.out.println(LongestSubstringAllUniqueChars("abcabcbb"));
    }

    public static int LongestSubstringAllUniqueChars(String s) {
        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            } else {
                map.put(s.charAt(j), 1);
            }
            int windowSize = j - i + 1;
            if (map.size() == windowSize) {
                max = max > windowSize ? max : windowSize;
            } else if (map.size() < j - i + 1) { // dont use windowsize variable ,   as if we are increasing i++ then its not going above windowsize to incrase its remaining same as windowssize variable is placed outside the loop so control is not going there untill inner while loop not completed fully
                while (map.size() < j - i + 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}
