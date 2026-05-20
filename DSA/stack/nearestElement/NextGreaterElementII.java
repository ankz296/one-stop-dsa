package DSA.stack.nearestElement;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    /**
     * https://leetcode.com/problems/next-greater-element-ii/
     * Here we choose claude AI's response.
     */
    public static int[] nextGreaterElements(int[] nums) {

        /**
         * Rule 1: 2*n
         *   "Array ko double karo mentally"
         *   "Har element ko wrap-around dekhne do"
         *   for (i = 0; i < 2*n; i++)
         *
         * Rule 2: i%n
         *   "Array bounds ke andar raho"
         *   "i=3 → 0, i=4 → 1, i=5 → 2"
         *   nums[i%n]
         *
         * Rule 3: i<n tabhi push
         *   "Sirf valid indices push karo"
         *   "Second pass mein sirf answers complete karo"
         *   if (i < n) stack.push(i)
         */
        int n = nums.length;
        int[] results = new int[n];
        Arrays.fill(results, -1); // default -1 sabke liye
        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) { // 2 baar traverse
            int currNum = nums[i % n]; // circular index

            while (!integerStack.isEmpty() && nums[integerStack.peek()] < currNum) {
                results[integerStack.pop()] = currNum; // answer store karo
            }
            // Sirf first pass mein push!
            if (i < n) {
                integerStack.push(i);
            }

        }
        return results;
    }

    static void main(String[] args) {
       // int[] nums = {1, 2, 1};
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
