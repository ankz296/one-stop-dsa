package DSA.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    /**
     * https://leetcode.com/problems/sliding-window-maximum/
     * https://www.youtube.com/watch?v=WcTMo1SHV_s
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/hard/SlidingWindowMaximum.java
     * https://algomaster.io/practice/dsa/sliding-window-maximum?list=am-300
     * Here we choose Nikhil Lohia's solution
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Initialize the deque and result array
        // Deque stores INDICES, not values
        Deque<Integer> integerDeque = new ArrayDeque<>();// deque for store the indices not the num
        int[] result = new int[n - k + 1];

        // Step 2: Setup deque for the first k elements
        for (int i = 0; i < k; i++) {
            // Remove all smaller elements from the back
            while (!integerDeque.isEmpty() && nums[integerDeque.peekLast()] < nums[i]) {
                integerDeque.pollLast();
            }
            integerDeque.offerLast(i);
        }

        // The front of the deque is the max of the first window
        result[0] = nums[integerDeque.peekFirst()];

        // Step 3: Process the remaining elements
        for (int i = k; i < n; i++) {

            // Remove the element that has slid out of the window
            if (integerDeque.peekFirst() <= i - k) {
                integerDeque.pollFirst();
            }

            // Remove all elements smaller than the incoming element
            while (!integerDeque.isEmpty() && nums[integerDeque.peekLast()] < nums[i]) {
                integerDeque.pollLast();
            }
            // Add current element's index
            integerDeque.offerLast(i);

            // The front of the deque is always the max of the current window
            result[i - k + 1] = nums[integerDeque.peekFirst()];
        }
        return result;

    }

    static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
