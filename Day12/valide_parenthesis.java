package Day12;

import java.util.Stack;

public class valide_parenthesis {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

            Open brackets must be closed by the same type of brackets.
            Open brackets must be closed in the correct order.

        

        Example 1:

        Input: s = "()"
        Output: true

        Example 2:

        Input: s = "()[]{}"
        Output: true

        Example 3:

        Input: s = "(]"
        Output: false

        

        Constraints:

            1 <= s.length <= 104
            s consists of parentheses only '()[]{}'.

     */

    /**
     * Solution
     * Using a Stack to store the characters
     * If a character is an opening bracket, we store it in the stack.
     * If the character is a closing bracket, we check if the corresponding opening bracket is present in the stack. If true, we pop the character
     * If false or the stack is empty then we push the current character to the stack.
     * The final answer is the boolean value if the stack is empty 
     * */   
    
     public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        int n = s.length();

        if(n == 0 || n == 1) return false;

        for(int i=0;i<n;i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if(c == ')') {
                    if(stack.isEmpty()) stack.push(c);
                    else if(stack.peek() == '(') stack.pop();
                    else stack.push(c);
                } else if(c == '}') {
                    if(stack.isEmpty()) stack.push(c);
                    else if(stack.peek() == '{') stack.pop();
                    else stack.push(c);
                } else if(c == ']') {
                    if(stack.isEmpty()) stack.push(c);
                    else if(stack.peek() == '[') stack.pop();
                    else stack.push(c);
                }
            }
        }

        return stack.isEmpty();
     }

    public static void main(String[] args) {
        String s = "(){}[]";

        System.out.print(solution(s));
    }
}
