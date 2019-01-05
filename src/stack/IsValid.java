package stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("{{"));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();//定义一个栈
        for(int i=0; i<chars.length; i++) {
            switch (chars[i]) {
                case '(':{
                    stack.push(chars[i]);
                    break;//压栈
                }
                case '{':{
                    stack.push(chars[i]);
                    break;//压栈
                }
                case '[':{
                    stack.push(chars[i]);
                    break;//压栈
                }
                case ')': {
                    if(stack.empty()) {
                        return false;
                    }
                    char value = stack.pop();
                    if(value != '(') {
                        return false;
                    }
                    break;//出栈匹配
                }
                case '}':{
                    if(stack.empty()) {
                        return false;
                    }
                    char value = stack.pop();
                    if(value != '{') {
                        return false;
                    }
                    break;
                }
                case ']':{
                    if(stack.empty()) {
                        return false;
                    }
                    char value = stack.pop();
                    if(value != '[') {
                        return false;
                    }
                    break;
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
