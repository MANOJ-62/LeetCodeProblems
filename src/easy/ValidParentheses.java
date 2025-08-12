package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode 20
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String inp = "({[]})";
        System.out.println("The Input is : " + isValid(inp));
    }
    public static boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('(',')');
        mappings.put('{','}');
        mappings.put('[',']');
        mappings.put('<','>');
        Stack<Character> stack = new Stack<>();
        for (Character ch: s.toCharArray()
        ) {
            if(mappings.containsKey(ch)){
//          If the character is an opening bracket, push it onto the stack
                stack.push(ch);
            } else if (mappings.values().contains(ch)) {
//          If the character is a closing bracket, check if it matches the most recent opening bracket
//          by popping the last opening bracket from the stack and comparing it with the current closing bracket
                if (stack.isEmpty() || mappings.get(stack.pop())!= ch){
                    return false;
                }
            }
        }
//      If the stack is empty, all brackets were matched properly
        return stack.isEmpty();
    }

//    Optimised Way without using HAshMap
    public static boolean isValidPerantheses(String s) {
    // Map for bracket matching: index 0 for '(', 1 for '{', 2 for '[', 3 for '<'
    char[] pair = {'(', '{', '[', '<'};
    Stack<Character> stack = new Stack<>();

    // Iterate through the string
    for (char ch : s.toCharArray()) {
        // Check if the character is one of the opening brackets
        if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
            stack.push(ch);
        } else {
            // If stack is empty or the current closing bracket does not match the last opened bracket, return false
            if (stack.isEmpty()) {
                return false;
            }
            char lastOpened = stack.pop();
            // Check for corresponding match
            if ((ch == ')' && lastOpened != '(') ||
                (ch == '}' && lastOpened != '{') ||
                (ch == ']' && lastOpened != '[') ||
                (ch == '>' && lastOpened != '<')) {
                return false;
            }
        }
    }

    // If the stack is empty, it means all brackets were properly matched
    return stack.isEmpty();
}

}
