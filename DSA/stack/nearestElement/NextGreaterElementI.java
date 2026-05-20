package DSA.stack.nearestElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    /**
     * https://leetcode.com/problems/next-greater-element-i/
     * https://algomaster.io/practice/dsa/next-greater-element-i?list=am-300
     * https://www.youtube.com/watch?v=mJWQjJpEMa4
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/easy/NextGreaterElementI.java
     * Here I follow Claude AI Solutions
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> integerStack = new Stack<>();

        // Step 1: nums2 process karo
        for (int i = 0; i < nums2.length; i++) {

            // Current num, stack top se bada hai?
            // → Stack top ka next greater = current num!
            while (!integerStack.isEmpty() && nums2[integerStack.peek()] < nums2[i]) {
                map.put(nums2[integerStack.pop()], nums2[i]);
            }
            integerStack.push(i);// waiting list mein daalo
        }

        // Step 2: Jo bache → next greater nahi mila
        while (!integerStack.isEmpty()) {
            map.put(nums2[integerStack.pop()], -1);
        }

        // Step 3: nums1 ke liye map se answer lo
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
