import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueCharacterSlidingWindow {
    public static void main(String[] args) {
        System.out.println(LongestSubStringKUniqueChar("abcabcbb", 2));
        System.out.println(LongestSubStringKUniqueChar("bbbbb", 2));
        System.out.println(LongestSubStringKUniqueChar("pwwkew", 2));
    }

    public static int LongestSubStringKUniqueChar(String str, int k) {
        int i = 0;
        int j = 0;
        int maximum = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while (j < str.length()) {
            if (map.containsKey(str.charAt(j))) {
                map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
            } else {
                map.put(str.charAt(j), 1);
            }
            int windowSize = j - i + 1;
            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                maximum = maximum > windowSize ? maximum : windowSize;
                j++;
            } else {
                while (map.size() > k) {
                    Character releaseCh = str.charAt(i);
                    map.put(releaseCh, map.get(releaseCh) - 1);
                    if (map.get(releaseCh) == 0) {
                        map.remove(releaseCh);
                    }
                    i++;
                }
                j++;
            }
        }
        return maximum;
    }
}
