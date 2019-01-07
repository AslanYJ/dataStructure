package stack;

import java.util.Stack;

public class BackspaceCompare {
    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        boolean result = backspaceCompare.backspaceCompare("a#c","b");
        System.out.println(result);
    }
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        char[] sArray = S.toCharArray();
        char[] tArray = T.toCharArray();
        for (char aSArray : sArray) {
                if (aSArray != '#') {
                    s.push(aSArray);
                } else {
                    if(!s.isEmpty()) {
                        s.pop();
                    }
                }
        }
        for(char aTArray : tArray ) {
            if(aTArray != '#') {
                t.push(aTArray);
            } else {
                if(!t.isEmpty()) {
                    t.pop();
                }
            }
        }
        if(t.isEmpty() && s.isEmpty()) {
            return true;
        }
        //不为空的话比较两字符串是否相等
        boolean result = true;
        if(s.size() != t.size()) {
            return false;
        }
        //两组是相等长度的比较内容
        int size = s.size();
        for(int i=0; i<size; i++) {
            if(s.get(i) != t.get(i)) {
                result = false;
            }
        }
        return result;
    }
}
