package DSA.stack.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /**
     * https://leetcode.com/problems/daily-temperatures/
     * https://www.youtube.com/watch?v=ekFs9Nb2RNQ
     * https://algomaster.io/practice/dsa/daily-temperatures?list=am-300
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/DailyTemperatures.java
     * https://github.com/developer-docs/Leetcode-Solutions/blob/main/739.%20Daily%20Temperatures
     */
    public static int[] dailyTemperatures(int[] temperatures) {
//        Stack<Integer> helperStack = new Stack<>();//
//        int n = temperatures.length;
//        int[] result = new int[n]; // result store here
//        for (int idx = n - 1; idx >= 0; idx--) {
//
//            // Popping all indices with a lower or equal
//            // temperature than the current index
//            while (!helperStack.empty() && temperatures[idx] >= temperatures[helperStack.peek()]) {
//                helperStack.pop();
//            }
//
//            // If the stack still has elements,
//            // then the next warmer temperature exists!
//            if (!helperStack.isEmpty()) {
//                result[idx] = helperStack.peek() - idx;
//            }
//
//            // Inserting current index in the stack
//            helperStack.push(idx);
//
//        }
//        return result;
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // indices store
        for (int i = 0; i < temperatures.length; i++) {
            // current temp stack top se zyada hai?
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                answer[stack.peek()] = i - stack.peek(); // kitne din baad
                stack.pop();
            }
            stack.push(i);  // current index push karo
        }
        return answer;
    }

    static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
