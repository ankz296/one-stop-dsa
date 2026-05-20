package DSA.hashMap.lookupBased;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    /**
     * https://leetcode.com/problems/longest-consecutive-sequence/description/
     * https://algomaster.io/practice/dsa/longest-consecutive-sequence?list=am-300
     * https://www.youtube.com/watch?v=LvbtUMdcgbw&t=310s
     */
    public static int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        // Step 1: Map mein daalo
        for (int num : nums) {
            visitedMap.put(num, Boolean.FALSE);
        }

        for (int num : nums) {

            // Already visited? Skip karo
            if (visitedMap.get(num).equals(Boolean.TRUE)) continue;

            int currentLength = 1; // num khud count karo ✅
            visitedMap.put(num, Boolean.TRUE); // num visited mark karo ✅
            // forward direction
            int nextNum = num + 1;
            while (visitedMap.containsKey(nextNum) && visitedMap.get(nextNum).equals(Boolean.FALSE)) {

                currentLength++;
                visitedMap.put(nextNum, Boolean.TRUE);
                nextNum++;
            }

            // backward direction
            int backNum = num - 1;
            while (visitedMap.containsKey(backNum) && visitedMap.get(backNum).equals(Boolean.FALSE)) {

                currentLength++;
                visitedMap.put(backNum, Boolean.TRUE);
                backNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
