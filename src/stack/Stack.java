package stack;
/**
 * 功能描述: 
 * 栈的实现。数组实现
 * @Author: lanyangjia
 * @Date: 2019/1/5 15:45
 * 
 */
public class Stack {
    private Object[] items;//数据存放的地方
    private int count;//栈中的元素个数
    private int n;//栈的大小
    public Stack(int n) {
        this.n = n;
        this.count = 0;
        this.items = new String[n];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());

    }

    //出栈
    public Object pop() {
        if(count == 0) return null;
        Object result = items[count - 1];//因为加最后的一个的还会再+1,因此这里要-1
        count--;
        return result;
    }

    //出栈
    public boolean push(Object o) {
        //要判断栈是不是为空了
        if(count == n) return false;
        items[count] = o;
        count++;
        return true;
    }
}
