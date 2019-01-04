package linklist;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。

 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            //这里不是回文链表，前后的值都不一样，取的是后一个值的话要再循环一次。
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
