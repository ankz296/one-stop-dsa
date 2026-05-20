package DSA.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestSubarrayWthSumLeastK {

    /**
     * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
     * Here we choose claude AI's response.
     */
    public static int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        Deque<Integer> integerDeque = new ArrayDeque<>();

        // Step 1: Prefix sum
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {

            // Step 2: Valid subarray check karo
            // Front se pop karo jab tak valid mile
            while (!integerDeque.isEmpty() && (prefix[i] - prefix[integerDeque.peekFirst()]) >= k) {
                minLength = Math.min(minLength, i - integerDeque.pollFirst());
            }

            // Step 3: Monotonic maintain karo
            // Back se bade prefix hatao (useless hain!)
            if (!integerDeque.isEmpty() && prefix[i] <= prefix[integerDeque.peekLast()]) {
                integerDeque.pollLast();
            }

            integerDeque.offerLast(i);

            //
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    static void main(String[] args) {
        int[] nums = {2, -1, 2};
        System.out.println(shortestSubarray(nums, 3));
    }
}
