package queue;
/**
 * 功能描述:
 * 数组 实现队列
 * @Author: lanyangjia
 * @Date: 2019/1/5 18:15
 *
 */
public class Queue {
    private String []items;
    private int n;//对列的大小;
    private int head;//头指针
    private int tail;//尾指针

    public Queue(int n) {
        this.n = n;
        items = new String[n];
        this.head = 0;
        this.tail = 0;
    }

    //入队
    public boolean enQueue(String item) {
        if(tail == n) {
            //下面是自动扩容的方法
            // tail ==n && head==0，表示整个队列都满了。没有出过队列
            if(head == 0) return false;//队列还没满
            //下面是扩容操作
            for(int i=head; i<tail; i++) {
                items[i-head] = items[i];//将当前head指向的元素移到对头
            }
            //搬运以后要更新tail和head
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String deQueue() {
        //出队。返回队列 中的头元素
        if(head == tail) {
            //当头和尾相等的时候就是最后一个指针了
            return null;
        }
        String item = items[head];
        ++head;
        return item;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue("4");
        System.out.println(queue.deQueue());

    }
}
