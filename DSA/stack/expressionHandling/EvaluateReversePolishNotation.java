package DSA.stack.expressionHandling;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
     * https://algomaster.io/practice/dsa/evaluate-reverse-polish-notation?list=am-300
     * https://github.com/developer-docs/Leetcode-Solutions/blob/main/150.%20Evaluate%20Reverse%20Polish%20Notation
     * Here we choose claude AI's response.
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> integerStack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {

                Integer b = integerStack.pop(); // second operand
                Integer a = integerStack.pop(); // first operand

                switch (token) {
                    case "+":
                        integerStack.push(a + b);
                        break;
                    case "-":
                        integerStack.push(a - b);
                        break;
                    case "/":
                        integerStack.push(a / b);
                        break;
                    case "*":
                        integerStack.push(a * b);
                        break;
                }
            } else {
                integerStack.push(Integer.parseInt(token));
            }
        }
        return integerStack.pop();
    }

    static void main(String[] args) {
        //String s = "()[]{}";
        String[] s = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(s));
    }
}
