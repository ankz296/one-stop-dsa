package DSA.array.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     * https://leetcode.com/problems/minimum-window-substring/
     * https://algomaster.io/practice/dsa/minimum-window-substring?list=am-300
     * https://www.youtube.com/watch?v=2leVSSd8L_o&t=628s
     */
    public static String minWindow(String s, String t) {
        // step - 1 freq map for count it
        // step - 2 will get size of map
        // step - 3 loop for window map from left to right
        // step - 4 in loop check freq map char and no of count match
        // step - 5 in loop if freq map and form size same then go to shrink window from left pointer to right
        if (s.length() < t.length()) return "";

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        // t ki frequency map
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int required = need.size(); // unique chars in t
        int formed = 0; // kitne chars apni freq pe pahunche

        // here we start the loop for update the window
        Map<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            // Step 1: right char add karo window mein
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);


            // Check karo kya yeh char apni required freq pe pahuncha
            if (need.containsKey(c) && need.get(c).equals(window.get(c))) {
                formed++;
            }
            // Step 2: Jab valid window mile — shrink karo
            while (formed == required && left <= right) {
                // calc min length
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                // left char remove karo
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
