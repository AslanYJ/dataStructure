package linklist;

/**
 * 功能描述:
 * 链表中的节点，有指针域和数据域
 * @Author: lanyangjia
 * @Date: 2019/1/3 12:22
 *
 */
public class Node<T> {
    public Node next;
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
