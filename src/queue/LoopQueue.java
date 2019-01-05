package queue;
/**
 * 功能描述: 
 * 循环队列,减少数据的搬运
 * @Author: lanyangjia
 * @Date: 2019/1/5 22:10
 * 
 */
public class LoopQueue {
    private String []items;
    private int n;//对列的大小;
    private int head;//头指针
    private int tail;//尾指针

    public LoopQueue(int n) {
        this.n = n;
    }

    //入队,循环队列的话会空一个存储位置出来，计算的方式是(指针+1)%size
    public boolean enqueue(String item) {
        if(((tail + 1) % n) == head) return false;//队列满了
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队列
    public String dequeue() {
        if(tail == head) {
            return null;//队列为空
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;

    }
}
