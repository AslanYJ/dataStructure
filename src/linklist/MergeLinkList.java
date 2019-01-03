package linklist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeLinkList {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode head = new ListNode(0);//新建一个链表
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        //补充剩下的
        while (l1 != null) {
            pre.next = l1;
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            pre.next = l2;
            pre = pre.next;
            l2 = l2.next;
        }

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
