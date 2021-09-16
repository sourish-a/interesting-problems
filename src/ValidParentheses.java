import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currCharacter = s.charAt(i);
            if (stack.empty()) {
                stack.add(currCharacter);
            } else if ((stack.peek() == '(' && currCharacter == ')') || (stack.peek() == '[' && currCharacter == ']') || (stack.peek() == '{' && currCharacter == '}')) {
                stack.pop();
            } else {
                stack.add(currCharacter);
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
