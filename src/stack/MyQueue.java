package stack;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。
 */
public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.size() == 0 && stack2.size() == 0) {
            //初始化的手两个都空的话，就先放stack1中。
            stack1.push(x);
        } else {
            if(!stack1.isEmpty()) {
                //如果这个不为空，证明队列有元素直接入队
                stack1.push(x);
            }
            if(!stack2.isEmpty()) {
                stack2.push(x);
            }
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack1.empty() && stack2.empty()) {
            return -1;
        }
        int result = 0;
        if(!stack1.isEmpty()) {
            int size = stack1.size();
            for(int i=0; i<size; i++) {
                stack2.push(stack1.pop());
            }
            result = stack2.pop();
        }
        //清空把原来的数据放回stack1
        if(!stack2.isEmpty()) {
            int size = stack2.size();
            for(int i=0; i<size; i++) {
                stack1.push(stack2.pop());
            }
        }

        return result;
    }

    /** Get the front element. */
    public int peek() {
        if(stack1.empty() && stack2.empty()) {
            return -1;
        }
        int result = 0;
        if(!stack1.isEmpty()) {
            int size = stack1.size();
            for(int i=0; i<size; i++) {
                stack2.push(stack1.pop());
            }
            result = stack2.peek();
        }
        //清空把原来的数据放回stack1
        if(!stack2.isEmpty()) {
            int size = stack2.size();
            for(int i=0; i<size; i++) {
                stack1.push(stack2.pop());
            }
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());// 返回 1
        System.out.println(queue.peek());// 返回 1
        System.out.println(queue.empty());// 返回 false
    }
}
