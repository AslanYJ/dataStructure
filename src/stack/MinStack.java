package stack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    //空间换时间，不用排序。每次插入两个值，一个是最小值，一个是本来的值
    private Stack<Integer> stack;//初始化一个栈
    public MinStack() {
        stack = new Stack<Integer>();
    }

    //压栈
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int k = stack.peek();
            stack.push(x);
            if(x < k) {
                stack.push(x);
            } else {
                stack.push(k);
            }
        }

    }

    //弹栈
    public void pop() {
        stack.pop();
        stack.pop();
    }

    //获取栈顶元素
    public int top() {
        return stack.get(stack.size() - 2);
    }

    //检索栈中的最小元素。
    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

    }
}
