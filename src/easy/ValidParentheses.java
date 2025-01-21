package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
}
