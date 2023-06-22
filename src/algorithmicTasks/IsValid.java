package algorithmicTasks;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.
//Example:
//
//        Input: s = "()"
//        Output: true
//        Example 2:
//
//        Input: s = "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: s = "(]"
//        Output: false

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        StringBuilder sB = new StringBuilder(s);
        for (int i = 0; i < sB.length() - 1; i += 2) {
            int increment = 0;
            if (sB.indexOf("(", increment) == i && sB.indexOf(")", increment) == i + 1) {
                increment += 2;
                continue;
            } else if (sB.indexOf("{", increment) == i && sB.indexOf("}", increment) == i + 1) {
                increment += 2;
                continue;
            } else if (sB.indexOf("[", increment) == i && sB.indexOf("]", increment) == i + 1) {
                increment += 2;
                continue;
            } else return false;
        }
        return true;
    }

//Suddenly, solution check said that "{[]}" is true too. Then, it requires another solution

    public boolean isItValidNow(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (character == '(')
                stack.push(')');
            else if (character == '{')
                stack.push('}');
            else if (character == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != character)
                return false;
        }
        return stack.isEmpty();
    }
}
