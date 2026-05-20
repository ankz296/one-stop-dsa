package DSA.stack.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class OnlineStockSpan {

    /**
     * https://leetcode.com/problems/online-stock-span/
     * https://algomaster.io/practice/dsa/online-stock-span?list=am-300
     * https://www.youtube.com/watch?v=jgEF8Dod5KE
     * https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/OnlineStockSpan.java
     */
//    public StockSpanner() {
//
//    }
    public static int[] calculateSpans(int[] prices) {

        Stack<Integer> helperStack = new Stack<>();
        // Push the index of first element
        helperStack.push(0);

        int[] spans = new int[prices.length];
        // Span of first element is always 1
        spans[0] = 1;

        for (int i = 1; i < prices.length; i++) {
            while (!helperStack.isEmpty() && prices[helperStack.peek()] <= prices[i]) {
                helperStack.pop();
            }
            // If index stack is empty, the price at index 'i'
            // is greater than all previous values
            // While ke baad spans calculate karo
            if (helperStack.isEmpty()) {
                spans[i] = i + 1;  // sab chote hain
            } else {
                spans[i] = i - helperStack.peek();// next greater se distance
            }
            // Bahar push karo
            helperStack.push(i);
        }
        return spans;
    }

    static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(calculateSpans(prices)));
    }
}
