package DSA.stack.expressionHandling;

import java.util.Stack;

public class ValidParentheses {

    /**
     * https://leetcode.com/problems/valid-parentheses
     * https://algomaster.io/practice/dsa/valid-parentheses?list=am-300
     * Here we choose claude AI's response.
     */
    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                characterStack.push(c);
            } else {

                // Stack empty → koi opening nahi tha
                if (characterStack.isEmpty()) return false;

                char top = characterStack.pop();

                if (top == '(' && c != ')') return false;
                if (top == '{' && c != '}') return false;
                if (top == '[' && c != ']') return false;
            }
        }
        return characterStack.isEmpty();
    }

    static void main(String[] args) {
        //String s = "()[]{}";
        String s = "(]";
        System.out.println(isValid(s));
    }
}
