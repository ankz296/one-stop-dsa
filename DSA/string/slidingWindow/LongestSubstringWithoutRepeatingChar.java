package DSA.string.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters
     * https://algomaster.io/practice/dsa/longest-substring-without-repeating-characters?list=am-300
     */
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastIndex.containsKey(c)) {
                // if char is found left will jump till dublicate char
                left = Math.max(left, lastIndex.get(c) + 1);

            }
            lastIndex.put(c, right); // update char latest index
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }

    static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
