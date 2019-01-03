package linklist;

/**
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkList {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;//保存前一个节点
        while (head != null) {
            ListNode node = head.next;
            head.next = pre;
            pre = head;
            head = node;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
