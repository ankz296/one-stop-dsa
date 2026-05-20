package DSA.stack.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleHistogram {

    /**
     * https://leetcode.com/problems/largest-rectangle-in-histogram
     * https://algomaster.io/practice/dsa/largest-rectangle-in-histogram?list=am-300
     */
    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> helperStack = new Stack<>();

        // i=n tak jaao — dummy height=0 for cleanup
        for (int i = 0; i <= n; i++) {
            int currHeight = i == n ? 0 : heights[i];

            // current chota hai stack top se → pop!
            while (!helperStack.isEmpty() && heights[helperStack.peek()] > currHeight) {

                int poppedIndex = helperStack.pop();
                int height = heights[poppedIndex];

                // width calculate karo
                int width = helperStack.isEmpty()
                        ? i // no left boundary
                        : i - helperStack.peek() - 1; // left boundary hai

                maxArea = Math.max(maxArea, width * height);
            }
            helperStack.push(i);
        }
        return maxArea;

    }

    static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

}
