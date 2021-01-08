package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    //
    //An input string is valid if:
    //
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.

    public boolean isValid(String s) {

        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('(', ')');
        characterMap.put('{', '}');
        characterMap.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }

            else if (stack.isEmpty()) {
                return false;
            }

            else if(s.charAt(i) == ')'){
                if (stack.pop() == '('){
                    continue;
                } else {
                    return false;
                }
            } else if(s.charAt(i) == '}'){
                if (stack.pop() == '{'){
                    continue;
                } else {
                    return false;
                }
            } else if(s.charAt(i) == ']'){
                if (stack.pop() == '['){
                    continue;
                } else {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

}
