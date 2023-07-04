package algorithmicTasks;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

//        Example 1:
//
//        Input: n = 3
//        Output: ["((()))","(()())","(())()","()(())","()()()"]

//        Example 2:
//
//        Input: n = 1
//        Output: ["()"]

import java.util.ArrayList;
import java.util.List;

//not my solution
//TODO: Study this process of using function in this function's code
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParentheses(result, "", 0, 0, n);
        return result;
    }

    private static void generateParentheses(List<String> result, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (open < n) {
            generateParentheses(result, str + '(', open + 1, close, n);
        }
        if (close < open) {
            generateParentheses(result, str + ')', open, close + 1, n);
        }
    }
}

