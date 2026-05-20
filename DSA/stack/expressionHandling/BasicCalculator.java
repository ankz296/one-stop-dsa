package DSA.stack.expressionHandling;

import java.util.Stack;

public class BasicCalculator {

    /**
     * https://leetcode.com/problems/basic-calculator/description/
     * Here we choose claude AI's response.
     */
    public static int calculate(String s) {
        Stack<Integer> integerStack = new Stack<>();
        int result = 0; // running total
        int sign = 1; // +1 ya -1
        int num = 0; // current number

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                // Number ban raha hai
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                // Pehle number add karo
                result += num * sign;
                sign = 1; // next sign positive
                num = 0; // reset
            } else if (c == '-') {
                // Pehle number add karo
                result += num * sign;
                sign = -1; // next sign negative
                num = 0; // reset
            } else if (c == '(') {
                // both result and sign should push in stack
                integerStack.push(result); // result save
                integerStack.push(sign); // sign save
                // reset all
                result = 0;
                num = 0;
                sign = 1;
            } else if (c == ')') {
                // Bracket ka last number add karo
                result += num * sign;
                num = 0; // reset

                // Combine with outside
                int preSign = integerStack.pop();
                int preResult = integerStack.pop();

                result = preResult + (result * preSign);
            }
            // ' ' → automatically ignore
        }
        result += num * sign;
        return result;
    }

    static void main(String[] args) {
        //String s = "()[]{}";
        //String s = " 2-1 + 2 ";
        String s = "1+(2-3)";
        System.out.println(calculate(s));
    }
}
