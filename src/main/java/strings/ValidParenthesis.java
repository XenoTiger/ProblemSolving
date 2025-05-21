package strings;

import java.util.Stack;

public class ValidParenthesis {

    private static boolean isValid(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                return s.isEmpty();
            }
        }
    }

    private static boolean isValidUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (c == ')' && top != '(' ||
                        c == '}' && top != '{' ||
                        c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    private static boolean balanceParenthesis(String s) {
        int roundCount = 0;
        int squareCount = 0;
        int curlyCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') roundCount++;
            else if (ch == ')') roundCount--;
            else if (ch == '[') squareCount++;
            else if (ch == ']') squareCount--;
            else if (ch == '{') curlyCount++;
            else if (ch == '}') curlyCount--;
        }
        return roundCount == 0 && squareCount == 0 && curlyCount == 0;
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        System.out.println(isValid(s1));
        String s2 = "][";
        System.out.println(isValid(s2));
        System.out.println(isValidUsingStack(s1));
        System.out.println(isValidUsingStack(s2));
        System.out.println(balanceParenthesis(s2));
    }
}
