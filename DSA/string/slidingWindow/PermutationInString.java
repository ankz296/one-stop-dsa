package DSA.string.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    /**
     * https://leetcode.com/problems/permutation-in-string/
     * https://algomaster.io/practice/dsa/permutation-in-string?list=am-300
     */
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // freq map for s1
        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int formed = 0;
        int required = need.size();
        int k = s1.length();
        for (int right = 0; right < s2.length(); right++) {

            // Step 1: right char add karo
            char ch = s2.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // formed check karo
            if (need.containsKey(ch) && need.get(ch).equals(window.get(ch))) {
                formed++;
            }
            // Step 2: window size = k hua? left remove karo
            // will slide left point
            if (right >= k) {
                char lc = s2.charAt(right - k);

                // formed check karo before remove
                if (need.containsKey(lc) && need.get(lc).equals(window.get(lc))) {
                    formed--;
                }

                window.put(lc, window.get(lc) - 1);

            }
            // Step 3: valid window?
            if (formed == required) return true;
        }
        return false;


    }

    static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

}
