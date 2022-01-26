import java.util.Stack;

public class LongestValidParenthesis {
    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     * Example 2:
     *
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * Example 3:
     *
     * Input: s = ""
     * Output: 0
     *
     *
     * Constraints:
     *
     * 0 <= s.length <= 3 * 104
     * s[i] is '(', or ')'.
     */

    /**
     * The initial idea is to add all the characters to a stack. Then continue to pop from the stack, and keep an openCount.
     * Decrement the openCount everytime smth gets closed.
     */
    public static int attempt1(String s) {
        if (null == s || s.length() <= 1) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                stack.push(i);
            } else if (currChar == ')') {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static int attempt1Helper(String s) {
        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            chars.add(s.charAt(i));
        char currChar;
        int openCount = 0, currLength = 0, maxLength = 0;
        while (!chars.empty()) {
            currChar = chars.pop();
            if (currChar == '(' && openCount > 0) {
                openCount--;
                currLength += 2;
            } else if (currChar == '(' && openCount == 0) {
                maxLength = Math.max(maxLength, currLength);
                currLength = 0;
            } else if (currChar == ')') {
                openCount++;
            }
        }
        maxLength = Math.max(maxLength, currLength);
        return maxLength;
    }
}
